package com.jd.axondemo.activity.service;

import com.jd.axondemo.activity.command.CreateActivityCommand;
import com.jd.axondemo.activity.dto.CreateActivityDTO;
import org.apache.log4j.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private CommandGateway commandGateway;

    public void createActivity(CreateActivityDTO dto) {
        try {
            commandGateway.send(new CreateActivityCommand(dto));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
