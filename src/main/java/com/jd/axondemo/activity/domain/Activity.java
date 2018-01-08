package com.jd.axondemo.activity.domain;

import com.jd.axondemo.activity.command.CreateActivityCommand;
import com.jd.axondemo.activity.event.ActivityCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;

public class Activity {

    @AggregateIdentifier
    private Long id;

    @CommandHandler
    public Activity(CreateActivityCommand command) {
        AggregateLifecycle.apply(new ActivityCreatedEvent());
    }

    @EventSourcingHandler
    public void handle(ActivityCreatedEvent event) {

    }
}
