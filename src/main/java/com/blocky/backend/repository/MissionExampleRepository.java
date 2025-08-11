package com.blocky.backend.repository;

import com.blocky.backend.entity.Mission;
import com.blocky.backend.entity.MissionExample;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MissionExampleRepository extends JpaRepository<MissionExample, Integer> {
    Optional<MissionExample> findByMission(Mission mission);
}
