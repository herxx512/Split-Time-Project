package com.brightpaths.fitnessApp.dtos;

import com.brightpaths.fitnessApp.entities.WorkoutSplit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutSplitDto implements Serializable {
    private Long id;
    private String exerciseName;
    private String day;
    private int sets;
    private int repititions;
    private String type;
    private UserDto userDto;

    public WorkoutSplitDto(WorkoutSplit split){
        if (split.getId() != null){
            this.id = split.getId();
        }

        if (split.getExerciseName() != null){
            this.exerciseName = split.getExerciseName();
        }

        if (split.getDay() != null){
            this.day = split.getDay();
        }

        if (split.getSets() != 0){
            this.sets = split.getSets();
        }

        if (split.getRepititions() != 0){
            this.repititions = split.getRepititions();
        }

        if (split.getType() != null){
            this.type = split.getType();
        }
    }

}
