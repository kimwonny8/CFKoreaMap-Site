package com.crossfit.server.exception.user;

import com.crossfit.server.exception.BusinessException;
import com.crossfit.server.exception.ErrorCode;

public class EmailDuplicationException extends BusinessException {

    public EmailDuplicationException() {
        super(ErrorCode.EMAIL_DUPLICATION);
    }
}