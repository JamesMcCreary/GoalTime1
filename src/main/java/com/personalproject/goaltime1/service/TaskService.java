package com.personalproject.goaltime1.service;

import java.util.List;

import com.personalproject.goaltime1.domain.Task;


public interface TaskService {

    List<Task> getTasks(String userName);
    Task getTaskById(Long id);
    // For use with $http from front-end
    // void addTask(Task taskToAdd);

    Task addTask(Task taskToAdd);

    void updateTask(Task taskToUpdate);
    void archiveTask(Task taskToArchive);
}
