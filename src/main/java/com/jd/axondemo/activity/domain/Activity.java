package com.jd.axondemo.activity.domain;

import com.jd.axondemo.activity.command.CreateActivityCommand;
import com.jd.axondemo.activity.command.EditActivityCommand;
import com.jd.axondemo.activity.dto.CreateActivityDTO;
import com.jd.axondemo.activity.event.ActivityCreatedEvent;
import com.jd.axondemo.activity.event.ActivityEditedEvent;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.*;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@NoArgsConstructor
@Aggregate
public class Activity {

    private static Logger logger = Logger.getLogger(Activity.class);

    @AggregateIdentifier
    private Long id;

    private String name;

    private Integer channel;

    private List<Integer> serviceIds = Collections.emptyList();

    private String description;

    private Date activityStartTime;

    private Date activityEndTime;

    private Date registerStartTime;

    private Date registerEndTime;

    private Collection<ActivityApply> activityApplies = Collections.emptyList();

    @CommandHandler
    public Activity(CreateActivityCommand command) {
        logger.info("Activity create command");
        apply(new ActivityCreatedEvent(command.getCreateActivityDTO()));
    }

    @EventSourcingHandler
    public void on(ActivityCreatedEvent event) {
        logger.info("Activity created event");
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
    }

    @CommandHandler
    public void handle(EditActivityCommand command) {
        apply(new ActivityCreatedEvent(command.getId(), command.getName(), command.getStartTime(), command.getEndTime()));
    }

    @EventSourcingHandler
    public void on(ActivityEditedEvent event) {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
