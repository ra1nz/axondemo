package com.jd.axondemo.activity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ActivityDTO {

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
    private Collection<ActivityApplyDTO> activityApplies;
}
