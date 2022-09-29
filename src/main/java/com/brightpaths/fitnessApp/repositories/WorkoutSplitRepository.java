package com.brightpaths.fitnessApp.repositories;

import com.brightpaths.fitnessApp.entities.User;
import com.brightpaths.fitnessApp.entities.WorkoutSplit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutSplitRepository extends JpaRepository<WorkoutSplit, Long> {
    List<WorkoutSplit> findAllByUserEquals(User user);

}
