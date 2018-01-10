package com.jd.axondemo.activity.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@RequiredArgsConstructor
public class ActivityApplyDTO {

    @Getter
    @Setter
    @NonNull
    private Long id;

    @Getter
    @Setter
    @NonNull
    private Long activityId;

    @Getter
    @Setter
    @NonNull
    private Integer channel;

    @Getter
    @Setter
    private String taskName;

    @Getter
    @Setter
    private Long brandServiceId;

    @Getter
    @Setter
    private Integer pushDataType;

    @Getter
    @Setter
    private Date startTime;

    @Getter
    @Setter
    private Date endTime;

    @Getter
    @Setter
    private Integer status;
}
