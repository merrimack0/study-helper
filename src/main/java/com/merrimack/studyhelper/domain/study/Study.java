package com.merrimack.studyhelper.domain.study;

import com.merrimack.studyhelper.domain.BaseTimeEntity;
import com.merrimack.studyhelper.domain.enumclass.DisplayStatus;
import com.merrimack.studyhelper.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name="study", schema = "study")
public class Study extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 500, nullable = false)
    private String content;

    private Long leaderId;

    private Long max;

    @Enumerated(EnumType.STRING)
    private DisplayStatus displayStatus;

    @Builder
    public Study(String title, String content, Long leaderId, Long max, DisplayStatus displayStatus){
        this.title = title;
        this.content = content;
        this.leaderId = leaderId;
        this.max = max;
        this.displayStatus = displayStatus;
    }

}
