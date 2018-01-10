package com.jd.axondemo.activity.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ActivityStatus {


    WAIT_FOR_REGISTER(1, "待报名"), REGISTER_IN_PROGRESS(2, "报名中"), REGISTER_FINISHED(3, "报名结束"),
    ACTIVITY_IN_PROGRESS(4, "活动进行中"), ACTIVITY_FINISHED(5, "活动结束"), DEPRECATED(6, "作废");

    @Getter
    private final int status;

    @Getter
    private final String statusName;


}
