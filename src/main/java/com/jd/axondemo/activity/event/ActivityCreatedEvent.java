package com.jd.axondemo.activity.event;

import com.jd.axondemo.activity.dto.CreateActivityDTO;

public class ActivityCreatedEvent {

    private CreateActivityDTO createActivityDTO;

    public ActivityCreatedEvent(CreateActivityDTO createActivityDTO) {
        this.createActivityDTO = createActivityDTO;
    }

    public ActivityCreatedEvent() {

    }

    public CreateActivityDTO getCreateActivityDTO() {
        return createActivityDTO;
    }

    public void setCreateActivityDTO(CreateActivityDTO createActivityDTO) {
        this.createActivityDTO = createActivityDTO;
    }
}
