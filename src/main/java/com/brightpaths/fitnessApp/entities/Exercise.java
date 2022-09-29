package com.brightpaths.fitnessApp.entities;


import com.brightpaths.fitnessApp.dtos.ExerciseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Exercises")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String photo;

    @Column
    private String tutorial;

    public Exercise(ExerciseDto exerciseDto){
        if (exerciseDto.getName() != null){
            this.name = exerciseDto.getName();
        }

        if (exerciseDto.getPhoto() != null){
            this.photo = exerciseDto.getPhoto();
        }

        if (exerciseDto.getTutorial() != null){
            this.tutorial = exerciseDto.getTutorial();
        }
    }
}
