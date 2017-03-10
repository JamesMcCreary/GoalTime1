package com.personalproject.goaltimepp.dao;

import java.util.List;

import com.personalproject.goaltimepp.domain.Task;

public interface TaskDao {

    List<Task> getTasks(String userName) throws IllegalArgumentException;
    Task getTaskById(Long id);
    void addTask(Task taskToAdd);
    void updateTask(Task taskToUpdate);
    void archiveTask(Task taskToArchive);
}
