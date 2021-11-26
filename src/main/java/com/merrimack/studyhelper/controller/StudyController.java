package com.merrimack.studyhelper.controller;

import com.merrimack.studyhelper.domain.user.request.UserRequest;
import com.merrimack.studyhelper.service.study.StudyService;
import com.merrimack.studyhelper.support.ApiResult;
import com.merrimack.studyhelper.support.ApiStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/study")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudyController {

    @Autowired
    StudyService studyService;

    @PostMapping("/create")
    public ApiResult create(@RequestBody UserRequest userRequest) {
        studyService.createStudy(userRequest);
        return ApiResult.of(ApiStatus.SUCCESS);
    }

    @DeleteMapping("/delete")
    public ApiResult delete(@RequestBody UserRequest userRequest) {
        studyService.removeStudy(userRequest);
        return ApiResult.of(ApiStatus.SUCCESS);
    }
}
