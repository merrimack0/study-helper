package com.merrimack.studyhelper.domain.user.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChangeStudyRequest {

    @NotNull
    private Long studyId;

    @NotNull
    private List<Integer> timeIds;

}
