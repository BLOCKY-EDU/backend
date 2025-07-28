package com.blocky.backend.repository;

import com.blocky.backend.entity.MissionRun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRunRepository extends JpaRepository<MissionRun, Integer> {
}
