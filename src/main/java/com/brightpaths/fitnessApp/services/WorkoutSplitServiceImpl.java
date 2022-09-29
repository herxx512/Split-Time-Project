package com.brightpaths.fitnessApp.services;

import com.brightpaths.fitnessApp.dtos.WorkoutSplitDto;
import com.brightpaths.fitnessApp.entities.User;
import com.brightpaths.fitnessApp.entities.WorkoutSplit;
import com.brightpaths.fitnessApp.repositories.UserRepository;
import com.brightpaths.fitnessApp.repositories.WorkoutSplitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkoutSplitServiceImpl implements WorkoutSplitService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkoutSplitRepository workoutSplitRepository;

    @Override
    @Transactional
    public  void addSplit(WorkoutSplitDto splitDto, Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        WorkoutSplit workoutSplit = new WorkoutSplit(splitDto);
        userOptional.ifPresent(workoutSplit::setUser);
        workoutSplitRepository.saveAndFlush(workoutSplit);
    }

    @Override
    @Transactional
    public void  deleteSplitById(Long splitId){
        Optional<WorkoutSplit> splitOptional = workoutSplitRepository.findById(splitId);
        splitOptional.ifPresent(split -> workoutSplitRepository.delete(split));
    }

    @Override
    @Transactional
    public void updateSplitById(WorkoutSplitDto splitDto){
        Optional<WorkoutSplit> splitOptional = workoutSplitRepository.findById(splitDto.getId());
        splitOptional.ifPresent(split -> {
            split.setExerciseName(splitDto.getExerciseName());
            split.setDay(splitDto.getDay());
            split.setSets(Integer.parseInt(String.valueOf(splitDto.getSets())));
            split.setRepititions(Integer.parseInt(String.valueOf(splitDto.getRepititions())));
            split.setType(splitDto.getType());
            workoutSplitRepository.saveAndFlush(split);
        });
    }

    @Override
    public List<WorkoutSplitDto> getAllSplitByUserId(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            List<WorkoutSplit> splitList = workoutSplitRepository.findAllByUserEquals(userOptional.get());
            return splitList.stream().map(split -> new WorkoutSplitDto(split)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<WorkoutSplitDto> getSplitById(Long splitId) {
        Optional<WorkoutSplit> splitOptional = workoutSplitRepository.findById(splitId);
        if (splitOptional.isPresent()){
            return Optional.of(new WorkoutSplitDto(splitOptional.get()));
        }
        return Optional.empty();
    }
}
