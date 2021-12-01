package com.merrimack.studyhelper.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.merrimack.studyhelper.domain.BaseTimeEntity;
import com.merrimack.studyhelper.domain.study.Study;
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
@Table(name = "user", schema = "study")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String email;

    private String phoneNumber;

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "study_user_mapping",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "study_id")
    )
    private List<Study> studys;

    @Builder
    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void addStudy(Study study) {
        if (Objects.isNull(studys)) {
            studys = new ArrayList<>();
        }
        studys.add(study);
    }
}