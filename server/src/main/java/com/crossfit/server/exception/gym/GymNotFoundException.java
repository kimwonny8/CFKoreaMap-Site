package com.crossfit.server.exception.gym;

import com.crossfit.server.exception.BusinessException;
import com.crossfit.server.exception.ErrorCode;

public class GymNotFoundException extends BusinessException {
    public GymNotFoundException() {
        super(ErrorCode.GYM_NOT_FOUND);
    }
}
