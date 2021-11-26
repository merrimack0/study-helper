package com.merrimack.studyhelper.domain.user.request;

import lombok.Getter;
import lombok.Setter;

import javax.security.auth.Subject;

@Getter
@Setter

public class CreateStudy {

    private String title;

    private Long studyId;

    private String content;

    private Long leaderId;

    private Long max;

    private String time;

    private String place;

    private Subject subject;
}
