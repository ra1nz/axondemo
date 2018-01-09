package com.jd.axondemo;

import com.jd.axondemo.activity.command.CreateActivityCommand;
import com.jd.axondemo.activity.domain.Activity;
import com.jd.axondemo.activity.event.ActivityCreatedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.mongo.MongoTemplate;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AxondemoApplicationTests {

    private AggregateTestFixture<Activity> aggregateTestFixture;

    @Before
    public void contextLoads() {
        aggregateTestFixture = new AggregateTestFixture(Activity.class);
    }

    @Test
    public void testCreateActivityCommand() {
        Date startTime = new Date();
        Date endTime = new Date(startTime.getTime() + 24 * 60 * 60 * 1000 * 3);
        aggregateTestFixture.givenNoPriorActivity()
                .when(new CreateActivityCommand(123456L, "活动1", startTime, endTime))
                .expectEvents(new ActivityCreatedEvent(123456L, "活动1", startTime, endTime));
    }

}
