package com.jd.axondemo.activity.dto;

import java.util.Date;

public class ActivityApplyDTO {

    private Long id;

    private Long activityId;

    private Integer channel;

    private String taskName;

    private Long brandServiceId;

    private Integer pushDataType;

    private Date startTime;

    private Date endTime;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Long getBrandServiceId() {
        return brandServiceId;
    }

    public void setBrandServiceId(Long brandServiceId) {
        this.brandServiceId = brandServiceId;
    }

    public Integer getPushDataType() {
        return pushDataType;
    }

    public void setPushDataType(Integer pushDataType) {
        this.pushDataType = pushDataType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
