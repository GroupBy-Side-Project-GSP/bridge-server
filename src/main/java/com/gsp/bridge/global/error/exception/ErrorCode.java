package com.gsp.bridge.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    COMPANY_NOT_FOUND(404, "COMPANY-404-1", "Company Not Found.");

    private final int status;
    private final String code;
    private final String message;
}