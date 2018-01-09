package com.jd.axondemo.activity.command;

import com.jd.axondemo.activity.dto.CreateActivityDTO;

public class CreateActivityCommand {

    private final CreateActivityDTO createActivityDTO;

    public CreateActivityCommand(CreateActivityDTO createActivityDTO) {
        this.createActivityDTO = createActivityDTO;
    }

    public CreateActivityDTO getCreateActivityDTO() {
        return createActivityDTO;
    }
}
