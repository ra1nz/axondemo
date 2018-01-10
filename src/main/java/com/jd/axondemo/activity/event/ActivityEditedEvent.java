package com.jd.axondemo.activity.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class ActivityEditedEvent {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

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

}
