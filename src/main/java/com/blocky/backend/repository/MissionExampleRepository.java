package com.blocky.backend.repository;

import com.blocky.backend.entity.MissionExample;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MissionExampleRepository extends JpaRepository<MissionExample, Integer> {
    List<MissionExample> findByMission_MissionId(Integer missionId);
}
