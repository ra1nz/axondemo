package com.jd.axondemo.activity.query;

import com.jd.axondemo.activity.domain.Activity;
import com.jd.axondemo.activity.domain.ActivityApply;
import com.jd.axondemo.activity.dto.ActivityApplyDTO;
import com.jd.axondemo.activity.dto.ActivityDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.axonframework.commandhandling.model.Aggregate;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 查询处理器
 */
@Component
public class ActivityQueryHandler {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private Repository<Activity> repository;

    @QueryHandler
    public ActivityDTO query(IdQuery idQuery) {
        Aggregate<Activity> activityAggregate = repository.load(String.valueOf(idQuery.getId()));
        if (activityAggregate == null || activityAggregate.isDeleted()) {
            logger.warn("未找到聚合：" + idQuery.getId());
            return null;
        }
        return activityAggregate.invoke(activity -> convert(activity));
    }

    private ActivityDTO convert(Activity activity) {
        ActivityDTO dto = new ActivityDTO();
        dto.setId(activity.getId());
        dto.setName(activity.getName());
        dto.setChannel(activity.getChannel());
        dto.setServiceIds(activity.getServiceIds());
        dto.setDescription(activity.getDescription());
        dto.setActivityStartTime(activity.getActivityStartTime());
        dto.setActivityEndTime(activity.getActivityEndTime());
        dto.setRegisterStartTime(activity.getRegisterStartTime());
        dto.setRegisterEndTime(activity.getRegisterEndTime());
        dto.setStatus(activity.getStatus());
        Collection<ActivityApplyDTO> activityApplies = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(activity.getActivityApplies())) {
            for (ActivityApply aa : activity.getActivityApplies()) {
                ActivityApplyDTO applyDTO = new ActivityApplyDTO();
                applyDTO.setId(aa.getId());
                applyDTO.setActivityId(aa.getActivityId());
                applyDTO.setTaskName(aa.getTaskName());
                applyDTO.setBrandServiceId(aa.getBrandServiceId());
                applyDTO.setPushDataType(aa.getPushDataType());
                applyDTO.setStartTime(aa.getStartTime());
                applyDTO.setEndTime(aa.getEndTime());
                applyDTO.setStatus(aa.getStatus());
                activityApplies.add(applyDTO);
            }
        }
        dto.setActivityApplies(activityApplies);
        return dto;
    }
}
