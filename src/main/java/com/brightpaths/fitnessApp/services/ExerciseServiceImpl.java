package com.brightpaths.fitnessApp.services;

import com.brightpaths.fitnessApp.dtos.ExerciseDto;
import com.brightpaths.fitnessApp.entities.Exercise;
import com.brightpaths.fitnessApp.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;


    @Override
    public List<Exercise> getAllExercises(){
        return exerciseRepository.findAll();
    }

    @Override
    public Optional<ExerciseDto> getExerciseById(Long exerciseId){
        Optional<Exercise> exerciseOptional = exerciseRepository.findById(exerciseId);
        if (exerciseOptional.isPresent()){
            return Optional.of(new ExerciseDto(exerciseOptional.get()));
        }
        return Optional.empty();
    }
}
