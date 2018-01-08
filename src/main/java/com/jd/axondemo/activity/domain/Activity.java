package com.jd.axondemo.activity.domain;

import com.jd.axondemo.activity.command.CreateActivityCommand;
import com.jd.axondemo.activity.event.ActivityCreatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@NoArgsConstructor
public class Activity {

    @AggregateIdentifier
    private Long id;

    @CommandHandler
    public Activity(CreateActivityCommand command) {
        apply(new ActivityCreatedEvent());
    }

    @EventSourcingHandler
    public void handle(ActivityCreatedEvent event) {

    }
}
