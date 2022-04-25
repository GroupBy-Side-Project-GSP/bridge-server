package com.gsp.bridge.domain.notification.exception;

import com.gsp.bridge.global.error.exception.CustomException;
import com.gsp.bridge.global.error.exception.ErrorCode;

public class NotificationNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new NotificationNotFoundException();

    private NotificationNotFoundException() {
        super(ErrorCode.NOTIFICATION_NOT_FOUND);
    }
}
