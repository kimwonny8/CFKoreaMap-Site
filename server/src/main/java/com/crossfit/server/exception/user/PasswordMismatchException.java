package com.crossfit.server.exception.user;

import com.crossfit.server.exception.BusinessException;
import com.crossfit.server.exception.ErrorCode;

public class PasswordMismatchException extends BusinessException  {
    
    public PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH_ERROR);
    }
}
