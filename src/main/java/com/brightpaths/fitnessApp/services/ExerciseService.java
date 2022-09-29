package com.brightpaths.fitnessApp.services;

import com.brightpaths.fitnessApp.dtos.ExerciseDto;
import com.brightpaths.fitnessApp.entities.Exercise;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {
    List<Exercise> getAllExercises();

    Optional<ExerciseDto> getExerciseById(Long exerciseId);
}
