package com.blocky.backend.repository;

import com.blocky.backend.entity.MissionRun;
import com.blocky.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MissionRunRepository extends JpaRepository<MissionRun, Integer> {
    List<MissionRun> findByUser_UserId(Integer userId);
}
