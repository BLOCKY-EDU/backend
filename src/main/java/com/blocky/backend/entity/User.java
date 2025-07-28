package com.blocky.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String nickname;

    // 관계 매핑
    @OneToMany(mappedBy = "user")
    private List<MissionRun> missionRuns = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Project> projects = new ArrayList<>();
}
