package com.blocky.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MissionExample")
@Getter
@Setter
@NoArgsConstructor
public class MissionExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer exampleId;

    @ManyToOne
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @Column(columnDefinition = "TEXT")
    private String htmlCode;

    @Column(columnDefinition = "TEXT")
    private String blockJson;
}

