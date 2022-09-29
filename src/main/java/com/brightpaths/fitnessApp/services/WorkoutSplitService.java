package com.brightpaths.fitnessApp.services;

import com.brightpaths.fitnessApp.dtos.WorkoutSplitDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface WorkoutSplitService {
    @Transactional
    void addSplit(WorkoutSplitDto splitDto, Long userId);

    @Transactional
    void deleteSplitById(Long splitId);

    @Transactional
    void updateSplitById(WorkoutSplitDto splitDto);

    List<WorkoutSplitDto> getAllSplitByUserId(Long userId);

    Optional<WorkoutSplitDto> getSplitById(Long splitId);
}
