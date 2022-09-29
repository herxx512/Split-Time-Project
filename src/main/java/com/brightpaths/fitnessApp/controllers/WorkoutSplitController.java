package com.brightpaths.fitnessApp.controllers;

import com.brightpaths.fitnessApp.dtos.WorkoutSplitDto;
import com.brightpaths.fitnessApp.services.WorkoutSplitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/fitness/workout-splits")
public class WorkoutSplitController {
    @Autowired
    private WorkoutSplitService workoutSplitService;

    @GetMapping("/user/{userId}")
    public List<WorkoutSplitDto> getSplitsByUser(@PathVariable Long userId){
        return workoutSplitService.getAllSplitByUserId(userId);
    }

    @PostMapping("/user/{userId}")
    public void addSplit(@RequestBody WorkoutSplitDto splitDto, @PathVariable Long userId){
        workoutSplitService.addSplit(splitDto,userId);
    }

    @DeleteMapping("/{splitId}")
    public void deleteSplitById(@PathVariable Long splitId){
        workoutSplitService.deleteSplitById(splitId);
    }

    @PutMapping
    public void updateSplit(@RequestBody WorkoutSplitDto splitDto){
        workoutSplitService.updateSplitById(splitDto);
    }

    @GetMapping("/{splitId}")
    public Optional<WorkoutSplitDto> getSplitById(@PathVariable Long splitId){
        return workoutSplitService.getSplitById(splitId);
    }
}
