package com.merrimack.studyhelper.domain.user.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;


@Getter
@Setter
@Validated
public class UserRequest {

    @NotNull
    private Long id;

    @NotNull
    private Long studyId;

}
