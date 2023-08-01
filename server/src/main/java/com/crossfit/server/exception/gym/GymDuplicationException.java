package com.crossfit.server.exception.gym;

import com.crossfit.server.exception.BusinessException;
import com.crossfit.server.exception.ErrorCode;

public class GymDuplicationException extends BusinessException {
    public GymDuplicationException() {
        super(ErrorCode.GYM_DUPLICATION);
    }
}
