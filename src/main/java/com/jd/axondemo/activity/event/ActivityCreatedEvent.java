package com.jd.axondemo.activity.event;

import com.jd.axondemo.activity.dto.CreateActivityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ActivityCreatedEvent {

    @Getter
    @Setter
    private CreateActivityDTO createActivityDTO;

}
