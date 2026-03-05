package com.example.ouath.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // user
    USER_NOT_FOUND(404, "일치하는 유저가 존재하지 않습니다."),
    PASSWORD_MIS_MATCH(401, "비밀번호가 일치하지 않습니다."),
    INVALID_USER(401, "인증되지 않은 사용자 입니다."),

    // general
    BAD_REQUEST(400, "프론트 탓..."),
    INTERNAL_SERVER_ERROR(500, "서버 탓...");

    private final int statusCode;
    private final String message;
}
