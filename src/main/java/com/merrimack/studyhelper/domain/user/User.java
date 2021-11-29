package com.merrimack.studyhelper.domain.user;

import com.merrimack.studyhelper.domain.BaseTimeEntity;
import com.merrimack.studyhelper.domain.study.Study;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name="user", schema = "study")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String email;

    private String phoneNumber;

    @ManyToMany(mappedBy = "study", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Study> studys;

    @Builder
    public User(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}