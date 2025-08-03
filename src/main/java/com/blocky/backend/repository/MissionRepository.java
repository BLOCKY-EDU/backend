package com.blocky.backend.repository;

import com.blocky.backend.entity.Mission;
import com.blocky.backend.entity.Mission.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Integer> {
    List<Mission> findByLevel(Level level);
}
