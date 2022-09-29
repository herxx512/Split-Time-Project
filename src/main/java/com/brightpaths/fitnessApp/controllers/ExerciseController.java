package com.brightpaths.fitnessApp.controllers;

import com.brightpaths.fitnessApp.dtos.ExerciseDto;
import com.brightpaths.fitnessApp.entities.Exercise;
import com.brightpaths.fitnessApp.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/fitness/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping
    public List<Exercise> getAllExercises(){
        return exerciseService.getAllExercises();
    }

    @GetMapping("/{exerciseId}")
    public Optional<ExerciseDto> getExerciseById(@PathVariable Long exerciseId){
        return exerciseService.getExerciseById(exerciseId);
    }
}
