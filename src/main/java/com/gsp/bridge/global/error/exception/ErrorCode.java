package com.gsp.bridge.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    FORBIDDEN(403, "COMMON-03-1", "Forbidden");

    private final int status;
    private final String code;
    private final String message;
}
