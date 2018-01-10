package com.jd.axondemo.activity.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@AllArgsConstructor
public class AbandonActivityApplyCommand {

    @TargetAggregateIdentifier
    @Getter
    private final Long id;

    @Getter
    private final Long activityApplyId;
}
