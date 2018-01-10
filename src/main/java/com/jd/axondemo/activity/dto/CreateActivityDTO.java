package com.jd.axondemo.activity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CreateActivityDTO {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Integer channel;

    @Getter
    @Setter
    private List<Integer> serviceIds;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Date activityStartTime;

    @Getter
    @Setter
    private Date activityEndTime;

    @Getter
    @Setter
    private Date registerStartTime;

    @Getter
    @Setter
    private Date registerEndTime;

    @Getter
    @Setter
    private Integer status;

    @Getter
    @Setter
    private Collection<ActivityApplyDTO> activityApplies = Collections.emptyList();

}
