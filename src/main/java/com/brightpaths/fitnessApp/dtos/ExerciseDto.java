package com.brightpaths.fitnessApp.dtos;

import com.brightpaths.fitnessApp.entities.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseDto implements Serializable {
    private Long id;
    private String name;
    private String photo;
    private String tutorial;

    public ExerciseDto(Exercise exercise){
        if (exercise.getId() != null){
            this.id = exercise.getId();
        }

        if (exercise.getName() != null){
            this.name = exercise.getName();
        }

        if (exercise.getPhoto() != null){
            this.photo = exercise.getPhoto();
        }

        if (exercise.getTutorial() != null){
            this.tutorial = exercise.getTutorial();
        }
    }
}
