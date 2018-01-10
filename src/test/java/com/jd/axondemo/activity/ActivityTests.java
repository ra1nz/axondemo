package com.jd.axondemo.activity;

import com.jd.axondemo.activity.command.AbandonActivityApplyCommand;
import com.jd.axondemo.activity.command.AddActivityApplyCommand;
import com.jd.axondemo.activity.command.CreateActivityCommand;
import com.jd.axondemo.activity.command.StartRegisterCommand;
import com.jd.axondemo.activity.domain.Activity;
import com.jd.axondemo.activity.dto.ActivityApplyDTO;
import com.jd.axondemo.activity.dto.CreateActivityDTO;
import com.jd.axondemo.activity.event.ActivityApplyAbandonedEvent;
import com.jd.axondemo.activity.event.ActivityApplyAddedEvent;
import com.jd.axondemo.activity.event.ActivityCreatedEvent;
import com.jd.axondemo.activity.event.RegisterStartedEvent;
import org.apache.commons.lang3.RandomUtils;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;

import static com.jd.axondemo.activity.Tools.buidActivityApplyDTO;
import static com.jd.axondemo.activity.Tools.buildCreateActivityDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityTests {

    AggregateTestFixture<Activity> fixture = new AggregateTestFixture<>(Activity.class);

    @Test
    public void testCreateActivity() {
        CreateActivityDTO dto = buildCreateActivityDTO();
        fixture.givenNoPriorActivity().when(new CreateActivityCommand(dto))
                .expectEvents(new ActivityCreatedEvent(dto));
    }

    @Test
    public void testStartRegister() {
        CreateActivityDTO dto = buildCreateActivityDTO();
        fixture.givenCommands(new CreateActivityCommand(dto))
                .when(new StartRegisterCommand(dto.getId()))
                .expectEvents(new RegisterStartedEvent());
    }

    @Test
    public void testAddActivityApply() {
        CreateActivityDTO dto = buildCreateActivityDTO();
        Collection<ActivityApplyDTO> activityApplies = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            activityApplies.add(buidActivityApplyDTO(dto.getId(), Long.valueOf(i)));
        }
        fixture.givenCommands(new CreateActivityCommand(dto))
                .when(new AddActivityApplyCommand(dto.getId(), activityApplies))
                .expectEvents(new ActivityApplyAddedEvent(activityApplies));
    }

    @Test
    public void testAbandonActivityApply() {
        CreateActivityDTO dto = buildCreateActivityDTO();
        Collection<ActivityApplyDTO> activityApplies = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            activityApplies.add(buidActivityApplyDTO(dto.getId(), Long.valueOf(i)));
        }
        Long applyId = RandomUtils.nextLong(1, 5);
        fixture.givenCommands(new CreateActivityCommand(dto), new AddActivityApplyCommand(dto.getId(), activityApplies))
                .when(new AbandonActivityApplyCommand(dto.getId(), applyId))
                .expectEvents(new ActivityApplyAbandonedEvent(dto.getId(), applyId));
    }


}
