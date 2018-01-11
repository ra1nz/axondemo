package com.jd.axondemo.activity;

import com.jd.axondemo.activity.dto.ActivityDTO;
import com.jd.axondemo.activity.service.ActivityService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static com.jd.axondemo.activity.Tools.buildCreateActivityDTO;
import static com.jd.axondemo.activity.Tools.buidActivityApplyDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityServiceTests {

    @Autowired
    private ActivityService activityService;

    @Test
    public void testCreateActivity() {
        activityService.createActivity(buildCreateActivityDTO());
    }

    @Test
    public void testGetQctivityById() {
        ActivityDTO activityDTO = activityService.getActivity(1L);
        Assert.assertTrue(activityDTO == null || (activityDTO != null && activityDTO.getId() == 1));
    }

    @Test
    public void testStartActivityRegister() {
        boolean result = activityService.startActivityRegister(1L);
        Assert.assertTrue(result);
    }

    @Test
    public void testAddActivityApply() {
        boolean result = activityService.addActivityApply(1L, Arrays.asList(buidActivityApplyDTO(1L, 1L)));
        Assert.assertTrue(result);
    }
}
