package com.jd.axondemo.activity;

import com.jd.axondemo.activity.service.ActivityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jd.axondemo.activity.Tools.buildCreateActivityDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityServiceTests {

    @Autowired
    private ActivityService activityService;

    @Test
    public void testCreateActivity() {
        activityService.createActivity(buildCreateActivityDTO());
    }

}
