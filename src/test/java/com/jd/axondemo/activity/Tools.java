package com.jd.axondemo.activity;

import com.jd.axondemo.activity.dto.ActivityApplyDTO;
import com.jd.axondemo.activity.dto.CreateActivityDTO;
import org.apache.commons.lang3.RandomUtils;
import org.joda.time.LocalDate;

import java.util.Arrays;
import java.util.Date;

public class Tools {

    public static ActivityApplyDTO buidActivityApplyDTO(Long activityId, Long id) {
        ActivityApplyDTO dto = new ActivityApplyDTO(id, activityId, 1);
        dto.setTaskName("测试apply:" + id);
        dto.setBrandServiceId(RandomUtils.nextLong(1, 3));
        dto.setPushDataType(1);
        dto.setStartTime(new Date());
        dto.setEndTime(new Date());
        return dto;
    }

    public static CreateActivityDTO buildCreateActivityDTO() {
        CreateActivityDTO dto = new CreateActivityDTO();
        dto.setId(1L);
        dto.setName("测试活动");
        dto.setChannel(1);
        dto.setServiceIds(Arrays.asList(1, 2, 3));
        dto.setDescription("活动描述");
        Date startTime = LocalDate.now().toDate();
        Date endTime = LocalDate.now().plusDays(7).toDate();
        dto.setActivityStartTime(startTime);
        dto.setActivityEndTime(endTime);
        dto.setRegisterStartTime(startTime);
        dto.setRegisterEndTime(endTime);
        return dto;
    }
}
