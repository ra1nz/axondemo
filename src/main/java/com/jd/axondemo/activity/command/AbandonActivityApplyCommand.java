package com.jd.axondemo.activity.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class AbandonActivityApplyCommand {

    @TargetAggregateIdentifier
    private final Long activityId;

    private final Long activityApplyId;

    public AbandonActivityApplyCommand(Long activityId, Long activityApplyId) {
        this.activityId = activityId;
        this.activityApplyId = activityApplyId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public Long getActivityApplyId() {
        return activityApplyId;
    }
}
