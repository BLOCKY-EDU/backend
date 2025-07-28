package com.blocky.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "MissionRun")
@Getter
@Setter
@NoArgsConstructor
public class MissionRun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer runId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @Column(columnDefinition = "TEXT")
    private String htmlCode;

    @Column(columnDefinition = "TEXT")
    private String blockJson;

    private LocalDateTime savedAt;

    private LocalDateTime submittedAt;
}

