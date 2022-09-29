package com.brightpaths.fitnessApp.entities;

import com.brightpaths.fitnessApp.dtos.WorkoutSplitDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "WorkoutSplits")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutSplit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String exerciseName;

    @Column
    private String day;

    @Column
    private int sets;

    @Column
    private int repititions;

    @Column
    private String type;

    @ManyToOne
    @JsonBackReference
    private User user;

    public WorkoutSplit(WorkoutSplitDto splitDto){
        if (splitDto.getExerciseName() != null){
            this.exerciseName = splitDto.getExerciseName();
        }

        if (splitDto.getDay() != null){
            this.day = splitDto.getDay();
        }

        if (splitDto.getSets() != 0){
            this.sets = Integer.parseInt(String.valueOf(splitDto.getSets()));
        }

        if (splitDto.getRepititions() != 0){
            this.repititions = Integer.parseInt(String.valueOf(splitDto.getRepititions()));
        }

        if (splitDto.getType() != null){
            this.type = splitDto.getType();
        }
    }
}
