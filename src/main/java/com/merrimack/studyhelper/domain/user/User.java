package com.merrimack.studyhelper.domain.user;

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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String email;

    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    private List<Study> studies = new ArrayList<>();

    @Builder
    public User(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}