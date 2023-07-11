package com.crossfit.server.exception.user;

import com.crossfit.server.exception.BusinessException;
import com.crossfit.server.exception.ErrorCode;

public class UserNotFoundException extends BusinessException {

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}