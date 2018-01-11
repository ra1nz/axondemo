package com.jd.axondemo.activity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class ActivityApply {

    @Getter
    private Long id;

    @Getter
    private Long activityId;

    @Getter
    private String taskName;

    @Getter
    private Long brandServiceId;

    @Getter
    private Integer pushDataType;

    @Getter
    private Date startTime;

    @Getter
    private Date endTime;

    @Getter
    private Integer status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityApply that = (ActivityApply) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(activityId, that.activityId) &&
                Objects.equals(taskName, that.taskName) &&
                Objects.equals(brandServiceId, that.brandServiceId) &&
                Objects.equals(pushDataType, that.pushDataType) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, activityId, taskName, brandServiceId, pushDataType, startTime, endTime, status);
    }
}
