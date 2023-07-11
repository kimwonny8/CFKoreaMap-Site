package com.crossfit.server.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponseBody> handleBusinessException(final BusinessException ex) {
        log.error("handleEntityNotFoundException", ex);
        final ErrorCode errorCode = ex.getErrorCode();
        final ErrorResponseBody response = ErrorResponseBody.of(errorCode);
        return new ResponseEntity<>(response, errorCode.getStatus());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponseBody> handleAccessDeniedException(AccessDeniedException ex) {
        log.info("AccessDeniedException : {}", ex.getMessage());
        final ErrorResponseBody response = ErrorResponseBody.of(ErrorCode.HANDLE_ACCESS_DENIED);
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseBody> handleInternalServerException(Exception ex) {
        log.info("handleInternalServerException : {}", ex.getMessage());
        final ErrorResponseBody response = ErrorResponseBody.of(ErrorCode.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}