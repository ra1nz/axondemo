package com.jd.axondemo.activity.event;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ActivityApplyAbandonedEvent {

    @Getter
    @Setter
    private Long activityId;

    @Getter
    @Setter
    @NonNull
    private Long activityApplyId;
}
