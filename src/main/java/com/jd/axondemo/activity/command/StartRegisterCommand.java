package com.jd.axondemo.activity.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@AllArgsConstructor
public class StartRegisterCommand {

    @TargetAggregateIdentifier
    @Getter
    private Long id;

}
