package com.jd.axondemo.activity.event;

import com.jd.axondemo.activity.dto.ActivityApplyDTO;
import lombok.*;

import java.util.Collection;

@NoArgsConstructor
@RequiredArgsConstructor
public class ActivityApplyAddedEvent {

    @NonNull
    @Getter
    @Setter
    private Collection<ActivityApplyDTO> activityApplies;

}
