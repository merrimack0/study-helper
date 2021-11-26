package com.merrimack.studyhelper.domain.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum DisplayStatus {
    OPEN("모집", 0),
    CLOSE("모집완료", 1),
    SHOW("공개", 2),
    DELETE("비공개", 3)
    ;

    private String label;
    private Integer id;

}
