package com.jd.axondemo.activity.listener;

import com.jd.axondemo.activity.event.ActivityCreatedEvent;
import org.axonframework.eventhandling.EventHandler;

public class ActivityEventListener {

    @EventHandler
    public void handle(ActivityCreatedEvent event) {

    }
}
