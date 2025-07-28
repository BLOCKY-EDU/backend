package com.blocky.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Mission")
@Getter
@Setter
@NoArgsConstructor
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer missionId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Level level;

    public enum Level {
        초급, 중급, 고급
    }

    @OneToMany(mappedBy = "mission")
    private List<MissionExample> examples = new ArrayList<>();

    @OneToMany(mappedBy = "mission")
    private List<MissionRun> runs = new ArrayList<>();
}
