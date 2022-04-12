package com.gsp.bridge.domain.company.exception;

import com.gsp.bridge.global.error.exception.CustomException;
import com.gsp.bridge.global.error.exception.ErrorCode;

public class CompanyNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new CompanyNotFoundException();

    private CompanyNotFoundException() {
        super(ErrorCode.COMPANY_NOT_FOUND);
    }
}
