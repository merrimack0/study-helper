package com.merrimack.studyhelper.domain.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Time {

    ONE(1, 1),
    TWO(2, 2),
    THREE(3, 3),
    FOUR(4, 4),
    FIVE(5,5),
    SIX(6,6),
    SEVEN(7,7),
    EIGHT(8,8),
    NINE(9,9),
    TEN(10,10),
    ELEVEN(11,11),
    TWELVE(12,12),
    THIRTEEN(13,13),
    FOURTEEN(14,14),
    FIFTEEN(15,15),
    SIXTEEN(16,16),
    SEVENTEEN(17,17),
    EIGHTEEN(18,18),
    NINETEEN(19,19),
    TWENTY(20,20),
    TWENTYONE(21,21),
    TWENTYTWO(22,22),
    TWENTYTHREE(23,23),
    TWENTYFOUR(24,24)
    ;

    private Integer time;
    private Integer id;
}
