package com.personalproject.goaltimepp.service;

import java.util.List;

import com.personalproject.goaltimepp.domain.Task;


public interface TaskService {

    List<Task> getTasks(String userName);
    Task getTaskById(Long id);
    void addTask(Task taskToAdd);
    void updateTask(Task taskToUpdate);
    void archiveTask(Task taskToArchive);
}
