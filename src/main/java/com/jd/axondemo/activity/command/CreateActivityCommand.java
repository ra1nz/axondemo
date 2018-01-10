package com.jd.axondemo.activity.command;

import com.jd.axondemo.activity.dto.CreateActivityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CreateActivityCommand {

    @Getter
    private final CreateActivityDTO createActivityDTO;

}
