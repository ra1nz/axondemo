package com.jd.axondemo.activity.domain;

import com.jd.axondemo.activity.command.*;
import com.jd.axondemo.activity.constants.ActivityStatus;
import com.jd.axondemo.activity.dto.ActivityApplyDTO;
import com.jd.axondemo.activity.dto.CreateActivityDTO;
import com.jd.axondemo.activity.event.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.*;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@NoArgsConstructor
@Aggregate
public class Activity {

    @AggregateIdentifier
    @Getter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Integer channel;

    @Getter
    @Setter
    private List<Integer> serviceIds = Collections.emptyList();

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Date activityStartTime;

    @Getter
    @Setter
    private Date activityEndTime;

    @Getter
    @Setter
    private Date registerStartTime;

    @Getter
    @Setter
    private Date registerEndTime;

    @Getter
    @Setter
    private Integer status;

    @Getter
    @Setter
    private Collection<ActivityApply> activityApplies = Collections.emptyList();

    /**
     * 创建活动
     *
     * @param command
     */
    @CommandHandler
    public Activity(CreateActivityCommand command) {
        apply(new ActivityCreatedEvent(command.getCreateActivityDTO()));
    }

    @EventSourcingHandler
    public void on(ActivityCreatedEvent event) {
        CreateActivityDTO dto = event.getCreateActivityDTO();
        this.id = dto.getId();
        this.name = dto.getName();
        this.channel = dto.getChannel();
        if (CollectionUtils.isNotEmpty(dto.getServiceIds())) {
            this.serviceIds = new ArrayList<>(dto.getServiceIds());
        }
        this.description = dto.getDescription();
        this.activityStartTime = dto.getActivityStartTime();
        this.activityEndTime = dto.getActivityEndTime();
        this.registerStartTime = dto.getRegisterStartTime();
        this.registerEndTime = dto.getRegisterEndTime();
        this.status = ActivityStatus.WAIT_FOR_REGISTER.getStatus();
    }

    /**
     * 编辑活动
     *
     * @param command
     * @return
     */
    @CommandHandler
    public boolean handle(EditActivityCommand command) {
        //只有活动状态为待报名时允许编辑
        if (getStatus() != ActivityStatus.WAIT_FOR_REGISTER.getStatus()) {
            return false;
        }
        apply(new ActivityEditedEvent(command.getId(), command.getName(),
                command.getActivityStartTime(), command.getActivityEndTime(),
                command.getRegisterStartTime(), command.getRegisterEndTime()));
        return true;
    }

    @EventSourcingHandler
    public void on(ActivityEditedEvent event) {
        this.name = event.getName();
        this.activityStartTime = event.getActivityStartTime();
        this.activityEndTime = event.getActivityEndTime();
        this.registerStartTime = event.getRegisterStartTime();
        this.registerEndTime = event.getRegisterEndTime();
    }

    /**
     * 添加ActivityApply
     *
     * @param command
     * @return
     */
    @CommandHandler
    public boolean handle(AddActivityApplyCommand command) {
        if (CollectionUtils.isEmpty(command.getActivityApplyDTOS())) {
            return false;
        }
        apply(new ActivityApplyAddedEvent(command.getActivityApplyDTOS()));
        return true;
    }

    @EventSourcingHandler
    public void on(ActivityApplyAddedEvent event) {
        List<ActivityApply> activityApplies = new ArrayList<>(getActivityApplies().size() + event.getActivityApplies().size());
        activityApplies.addAll(getActivityApplies());
        for (ActivityApplyDTO dto : event.getActivityApplies()) {
            activityApplies.add(new ActivityApply(dto.getId(), getId(), dto.getTaskName(),
                    dto.getBrandServiceId(), dto.getPushDataType(), dto.getStartTime(), dto.getEndTime(), dto.getStatus()));
        }
        setActivityApplies(activityApplies);
    }

    /**
     * 移除ActivityApply
     *
     * @param command
     * @return
     */
    @CommandHandler
    public boolean handle(AbandonActivityApplyCommand command) {
        if (CollectionUtils.isEmpty(getActivityApplies())) {
            return false;
        }
        apply(new ActivityApplyAbandonedEvent(getId(), command.getActivityApplyId()));
        return true;
    }

    @EventSourcingHandler
    public void on(ActivityApplyAbandonedEvent event) {
        for (Iterator<ActivityApply> it = getActivityApplies().iterator(); it.hasNext(); ) {
            if (it.next().getId() == event.getActivityApplyId()) {
                it.remove();
                break;
            }
        }
    }

    /**
     * 开始活动报名
     *
     * @param command
     * @return
     */
    @CommandHandler
    public boolean handle(StartRegisterCommand command) {
        if (getStatus() != ActivityStatus.WAIT_FOR_REGISTER.getStatus()) {
            return false;
        }
        apply(new RegisterStartedEvent());
        return true;
    }

    @EventSourcingHandler
    public void on(RegisterStartedEvent event) {
        //设置状态为报名中
        setStatus(ActivityStatus.REGISTER_IN_PROGRESS.getStatus());
    }
}
