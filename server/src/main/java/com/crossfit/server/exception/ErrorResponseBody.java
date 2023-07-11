package com.crossfit.server.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponseBody{
    private HttpStatus status;
    private String code;
    private String message;

    private ErrorResponseBody(final ErrorCode code) {
        this.message = code.getMessage();
        this.status = code.getStatus();
        this.code = code.getCode();
    }

    public static ErrorResponseBody of(final ErrorCode code) {
        return new ErrorResponseBody(code);
    }
}