package com.jd.axondemo.activity.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Date;

public class EditActivityCommand {

    @TargetAggregateIdentifier
    private final Long id;

    private final String name;

    private final Date activityStartTime;

    private final Date activityEndTime;

    private final Date registerStartTime;

    private final Date registerEndTime;

    public EditActivityCommand(Long id, String name, Date activityStartTime, Date activityEndTime, Date registerStartTime, Date registerEndTime) {
        this.id = id;
        this.name = name;
        this.activityStartTime = activityStartTime;
        this.activityEndTime = activityEndTime;
        this.registerStartTime = registerStartTime;
        this.registerEndTime = registerEndTime;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getActivityStartTime() {
        return activityStartTime;
    }

    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public Date getRegisterStartTime() {
        return registerStartTime;
    }

    public Date getRegisterEndTime() {
        return registerEndTime;
    }
}
