package com.personalproject.goaltime1.dao;

import java.util.List;

import com.personalproject.goaltime1.domain.Task;

public interface TaskDao {

    List<Task> getTasks(String userName) throws IllegalArgumentException;
    Task getTaskById(Long id);
    //    For use with $http in front-end
    //    void addTask(Task taskToAdd);

    Task addTask(Task taskToAdd);
    void updateTask(Task taskToUpdate);
    void archiveTask(Task taskToArchive);
}
