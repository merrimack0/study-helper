package com.merrimack.studyhelper.domain.study;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.merrimack.studyhelper.domain.BaseTimeEntity;
import com.merrimack.studyhelper.domain.enumclass.DisplayStatus;
import com.merrimack.studyhelper.domain.enumclass.Time;
import com.merrimack.studyhelper.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "study", schema = "study")
public class Study extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 500, nullable = false)
    private String content;

    private Long leaderId;

    private Long max;

    @ElementCollection(targetClass = Time.class)
    @CollectionTable(name = "study_time_mapping",
            joinColumns = @JoinColumn(name = "study_id"))
    @Column(name = "time_id")
    private List<Time> times;

    @Enumerated(EnumType.STRING)
    private DisplayStatus displayStatus;

    @JsonManagedReference
    @ManyToMany(mappedBy = "studys", cascade = CascadeType.ALL)
    private List<User> users;

    @Builder
    public Study(String title, String content, Long leaderId, Long max, DisplayStatus displayStatus, List<Time> times) {
        this.title = title;
        this.content = content;
        this.leaderId = leaderId;
        this.max = max;
        this.displayStatus = displayStatus;
        this.times = times;
    }

    public void addTime(Time t) {
        if (Objects.isNull(times)) {
            times = new ArrayList<>();
        }
        times.add(t);
    }

    public void setTimes(List<Time> t) {
        if (Objects.isNull(times)) {
            times = new ArrayList<>();
        }
        times = t;
        System.out.println("?");
    }
}
