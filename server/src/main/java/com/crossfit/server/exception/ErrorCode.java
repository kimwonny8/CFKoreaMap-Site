package com.crossfit.server.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    // Common
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C001", "잘못된 입력 값 입니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "C002", "지원되지 않는 메서드입니다."),
    NOT_EXIST_API(HttpStatus.BAD_REQUEST, "C003", "요청하신 API 주소가 올바르지 않습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C004", "서버 에러입니다."),
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST, "C005", "잘못된 타입입니다."),
    HANDLE_ACCESS_DENIED(HttpStatus.FORBIDDEN, "C006", "접근 권한이 없습니다."),

    // Token
    REFRESH_TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED, "A001", "존재하지 않는 리프레쉬 토큰입니다."),
    TOKEN_INVALID(HttpStatus.UNAUTHORIZED, "A002", "유효하지 않은 토큰입니다."),
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "A003", "만료된 토큰입니다."),

    // Member
    PASSWORD_MISMATCH_ERROR(HttpStatus.BAD_REQUEST, "M000", "이메일 또는 비밀번호가 잘못 입력되었습니다."),
    EMAIL_DUPLICATION(HttpStatus.BAD_REQUEST, "M001", "중복된 이메일입니다."),
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "M002", "존재하지 않는 회원입니다."),
    USER_NOT_AUTHENTICATION(HttpStatus.UNAUTHORIZED, "M003", "권한이 없는 사용자입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}