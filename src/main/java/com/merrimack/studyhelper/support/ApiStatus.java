package com.merrimack.studyhelper.support;

import lombok.Getter;

@Getter
public enum ApiStatus implements ApiStatusResponsible {

    SUCCESS(0, "성공", false),
    UNEXPECTED_INTERNAL_ERROR(-500, "죄송합니다. 잠시 후 다시 시도해주세요", false),
    REST_TEMPLATE_REQUEST_FAILED(-500, "요청이 처리 되지 않았습니다", false),
    BAD_REQUEST_ERROR(-400, "파라미터 형식이 잘못되었습니다.", false),
    REQUEST_METHOD_NOT_SUPPORTED(-405, "지원하지 않는 요청입니다.", true),
    MISSING_REQUEST_PARAMETER(-500, "필수 정보가 존재하지 않습니다.", true),

    PRODUCT_ID_NOT_EXIST(-100, "해당 상품이 존재하지 않습니다.", false),
    USER_ID_NOT_EXIST(-101, "해당 유저가 존재하지 않습니다.", false)

    ;
    private Integer code;
    private String message;
    private boolean isShort;

    ApiStatus(Integer code, String message, boolean isShort) {
        this.code = code;
        this.message = message;
        this.isShort = isShort;
    }
}
