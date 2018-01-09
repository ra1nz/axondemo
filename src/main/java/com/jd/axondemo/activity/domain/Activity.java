package com.jd.axondemo.activity.domain;

import com.jd.axondemo.activity.command.CreateActivityCommand;
import com.jd.axondemo.activity.command.EditActivityCommand;
import com.jd.axondemo.activity.event.ActivityCreatedEvent;
import com.jd.axondemo.activity.event.ActivityEditedEvent;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@NoArgsConstructor
@Aggregate
public class Activity {

    private static Logger logger = Logger.getLogger(Activity.class);

    @AggregateIdentifier
    private Long id;

    private String name;

    private Integer channel;

    private List<Long> serviceIds;

    private String description;

    private Date startTime;

    private Date endTime;

    private Date registerStartTime;

    private Date registerEndTime;

    private Collection<ActivityApply> activityApplies = Collections.emptyList();

    @CommandHandler
    public Activity(CreateActivityCommand command) {
        logger.info("Activity create command");
        apply(new ActivityCreatedEvent(command.getId(), command.getName(), command.getStartTime(), command.getEndTime()));
    }

    @EventSourcingHandler
    public void on(ActivityCreatedEvent event) {
        logger.info("Activity created event");
        this.id = event.getId();
        this.name = event.getName();
        this.startTime = event.getStartTime();
        this.endTime = event.getEndTime();
    }

    @CommandHandler
    public void handle(EditActivityCommand command) {
        apply(new ActivityCreatedEvent(command.getId(), command.getName(), command.getStartTime(), command.getEndTime()));
    }

    public void on(ActivityEditedEvent event) {
        this.name = event.getName();
        this.startTime = event.getStartTime();
        this.endTime = event.getEndTime();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
}
