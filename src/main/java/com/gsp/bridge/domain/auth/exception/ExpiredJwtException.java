package com.gsp.bridge.domain.auth.exception;

import com.gsp.bridge.global.error.exception.CustomException;
import com.gsp.bridge.global.error.exception.ErrorCode;

public class ExpiredJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
