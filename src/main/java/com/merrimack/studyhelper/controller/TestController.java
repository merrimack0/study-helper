package com.merrimack.studyhelper.controller;


import com.merrimack.studyhelper.service.study.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    StudyService studyService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
