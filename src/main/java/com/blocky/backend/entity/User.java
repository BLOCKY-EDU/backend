package com.blocky.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User") // 기존 테이블명 유지
@Getter @Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;   // ← Integer 유지

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String nickname;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<MissionRun> missionRuns = new ArrayList<>();

    // 필요 시 복구(선택). 이제 Project에 user 필드가 있으므로 에러 안 납니다.
    // @OneToMany(mappedBy = "user")
    // @JsonIgnore
    // private List<Project> projects = new ArrayList<>();
}
