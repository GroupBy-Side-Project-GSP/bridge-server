package com.gsp.bridge.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    COMPANY_NOT_FOUND(404, "COMPANY-404-1", "Company Not Found."),

    EXPIRED_TOKEN(401, "TOKEN-401-1", "Expired Token"),
    INVALID_TOKEN(401, "TOKEN-401-2", "Invalid Token"),

    INTERNAL_SERVER_ERROR(500, "SERVER-500-1", "Internal Server Error"),

    NOTIFICATION_NOT_FOUND(404, "NOTIFICATION-404-1", "Notification Not Found");

    private final int status;
    private final String code;
    private final String message;
}
