package com.gsp.bridge.infrastructure;

import com.gsp.bridge.infrastructure.dto.NotificationRequest;
import com.gsp.bridge.infrastructure.dto.SubscribeRequest;

public interface FcmUtil {

    void initialize();

    void sendNotification(NotificationRequest sendDto);

    void subscribeTopic(SubscribeRequest request);
}
