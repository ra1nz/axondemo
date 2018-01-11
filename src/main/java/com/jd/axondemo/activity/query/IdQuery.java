package com.jd.axondemo.activity.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@AllArgsConstructor
public class IdQuery {

    @TargetAggregateIdentifier
    @Getter
    private Long id;
}
