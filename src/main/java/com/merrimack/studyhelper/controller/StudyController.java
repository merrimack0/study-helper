package com.merrimack.studyhelper.controller;

import com.merrimack.studyhelper.domain.study.Study;
import com.merrimack.studyhelper.domain.user.request.StudyRequest;
import com.merrimack.studyhelper.domain.user.request.UserRequest;
import com.merrimack.studyhelper.service.study.StudyService;
import com.merrimack.studyhelper.support.ApiResult;
import com.merrimack.studyhelper.support.ApiStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/study")
@ResponseBody
public class StudyController {

    @Autowired
    StudyService studyService;

    @PostMapping("/create")
    public ApiResult create(@RequestBody StudyRequest studyRequest) {
        studyService.createStudy(studyRequest);
        return ApiResult.of(ApiStatus.SUCCESS);
    }

    @DeleteMapping("/delete")
    public ApiResult delete(@RequestBody StudyRequest studyRequest) {
        studyService.removeStudy(studyRequest);
        return ApiResult.of(ApiStatus.SUCCESS);
    }

    @PostMapping("/join")
    public ApiResult join(@Validated @RequestBody UserRequest userRequest) {
        studyService.joinStudy(userRequest);
        return ApiResult.of(ApiStatus.SUCCESS);
    }

    @GetMapping
    public List<Study> findAll() {
        return studyService.findAll();
    }
}
