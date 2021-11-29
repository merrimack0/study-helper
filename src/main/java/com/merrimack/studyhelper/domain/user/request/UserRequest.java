package com.merrimack.studyhelper.domain.user.request;

import com.merrimack.studyhelper.support.ApiException;
import com.merrimack.studyhelper.support.ApiStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter

public class UserRequest {

    private Long id;

    private String name;

    private Long studyId;

    public void validate() {
        if (Objects.isNull(id) || Objects.isNull(studyId)) {
            throw new ApiException(ApiStatus.MISSING_REQUEST_PARAMETER);
        }
    }
}
