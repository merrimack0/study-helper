package com.merrimack.studyhelper.domain.user.request;

import com.merrimack.studyhelper.support.ApiException;
import com.merrimack.studyhelper.support.ApiStatus;
import lombok.Getter;
import lombok.Setter;

import javax.security.auth.Subject;
import java.util.Objects;

@Getter
@Setter

public class StudyRequest {

    private String title;

    private Long studyId;

    private String content;

    private Long leaderId;

    private Long max;

    private String time;

    private String place;

    private Subject subject;

    public void validate() {
        if (Objects.isNull(title) || Objects.isNull(content)) {
            throw new ApiException(ApiStatus.MISSING_REQUEST_PARAMETER);
        }
    }
}
