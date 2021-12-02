package com.merrimack.studyhelper.common.config;

import com.merrimack.studyhelper.support.ApiResult;
import com.merrimack.studyhelper.support.ApiStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ApiResult exception(Exception e) {
        System.out.println(e.getMessage());
        return ApiResult.of(ApiStatus.REST_TEMPLATE_REQUEST_FAILED);
    }

    @ExceptionHandler(value = InvalidDataAccessApiUsageException.class)
    public ApiResult InvalidDataAccessApiUsageException(InvalidDataAccessApiUsageException e) {
        return ApiResult.of(ApiStatus.MISSING_REQUEST_PARAMETER);
    }
}