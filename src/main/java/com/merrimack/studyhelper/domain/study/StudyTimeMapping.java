package com.merrimack.studyhelper.domain.study;

import com.merrimack.studyhelper.domain.enumclass.Time;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@Table(name="study_time_mapping", schema = "study")
public class StudyTimeMapping implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_id", referencedColumnName = "id")
    private Study study;

    @Id
    @Enumerated
    @JoinColumn(name = "time_id", referencedColumnName = "id")
    private Time time;

}