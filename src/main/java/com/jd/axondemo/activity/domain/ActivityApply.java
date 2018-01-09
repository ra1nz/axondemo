package com.jd.axondemo.activity.domain;

import java.util.Date;

public class ActivityApply {

    private Long id;

    private Long activityId;

    private String taskName;

    private Long serviceId;

    private Integer pushDataType;

    private Date startTime;

    private Date endTime;

    private Integer status;

    public ActivityApply(Long id, Long activityId, String taskName, Long serviceId, Integer pushDataType, Date startTime, Date endTime, Integer status) {
        this.id = id;
        this.activityId = activityId;
        this.taskName = taskName;
        this.serviceId = serviceId;
        this.pushDataType = pushDataType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public String getTaskName() {
        return taskName;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public Integer getPushDataType() {
        return pushDataType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Integer getStatus() {
        return status;
    }
}
