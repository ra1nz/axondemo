package com.jd.axondemo.activity.listener;

import com.jd.axondemo.activity.event.ActivityCreatedEvent;
import com.jd.axondemo.activity.event.RegisterStartedEvent;
import org.apache.log4j.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

public class ActivityEventListener {

    private Logger logger = Logger.getLogger(getClass());

    @EventHandler
    public void on(ActivityCreatedEvent event) {
        logger.info("do something...");
    }

    @EventHandler
    public void on(RegisterStartedEvent event) {
        logger.info("do something...");
    }

}
