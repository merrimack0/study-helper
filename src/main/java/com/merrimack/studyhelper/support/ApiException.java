package com.merrimack.studyhelper.support;

import lombok.Getter;

public class ApiException extends RuntimeException {
    @Getter
    private ApiStatusResponsible apiStatus;

    @Getter
    private boolean customMessage = false;

    public ApiException(ApiStatusResponsible apiStatus) {
        super(apiStatus.getMessage());
        this.apiStatus = apiStatus;
    }
}
