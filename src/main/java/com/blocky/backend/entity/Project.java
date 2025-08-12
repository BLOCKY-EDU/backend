package com.blocky.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "projects")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    // User.userId가 Integer라면 여기도 Integer로 통일
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(nullable = false, length = 200)
    private String title;

    @Lob
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String htmlCode;

    @Lob
    @Column(nullable = false, columnDefinition = "LONGTEXT") // MySQL8이면 JSON도 가능
    private String blockJson;

    @Column(nullable = false)
    private LocalDate createdAt;

    // 호환용 읽기 전용 연관(기존 User.projects(mappedBy="user")를 만족시키기 위해)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    private User user;

    @PrePersist
    void prePersist() {
        if (createdAt == null) createdAt = LocalDate.now();
    }
}
