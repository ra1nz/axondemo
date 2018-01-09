package com.jd.axondemo.activity.command;

import com.jd.axondemo.activity.dto.ActivityApplyDTO;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Collection;

public class AddActivityApplyCommand {

    @TargetAggregateIdentifier
    private Long id;

    private Collection<ActivityApplyDTO> activityApplyDTOS;

    public AddActivityApplyCommand(Long id, Collection<ActivityApplyDTO> activityApplyDTOS) {
        this.id = id;
        this.activityApplyDTOS = activityApplyDTOS;
    }

    public Long getId() {
        return id;
    }

    public Collection<ActivityApplyDTO> getActivityApplyDTOS() {
        return activityApplyDTOS;
    }
}
