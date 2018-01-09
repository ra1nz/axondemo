package com.jd.axondemo.activity.event;

import java.util.Date;

public class ActivityEditedEvent {

    private Long id;

    private String name;

    private Date startTime;

    private Date endTime;

    public ActivityEditedEvent(Long id, String name, Date startTime, Date endTime) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
}
