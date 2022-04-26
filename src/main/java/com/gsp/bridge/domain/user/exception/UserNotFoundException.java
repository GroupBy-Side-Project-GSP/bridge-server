package com.gsp.bridge.domain.user.exception;

import com.gsp.bridge.global.error.exception.CustomException;
import com.gsp.bridge.global.error.exception.ErrorCode;

public class UserNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
