package com.personalproject.goaltimepp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.personalproject.goaltimepp.dao.TaskDao;
import com.personalproject.goaltimepp.domain.Task;

@Service("taskService")
//@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class TaskServiceImpl implements TaskService {

    @Resource(name="staticTasks")
    private TaskDao taskDao;

    @Override
    public List<Task> getTasks(String userName) {
        return taskDao.getTasks(userName);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskDao.getTaskById(id);
    }

    @Override
    public void addTask(Task taskToAdd) {
        taskDao.addTask(taskToAdd);
    }

    @Override
    public void updateTask(Task taskToUpdate) {
        taskDao.updateTask(taskToUpdate);
    }

    @Override
    public void archiveTask(Task taskToArchive) {

        taskToArchive.setArchived(true);
        taskDao.archiveTask(taskToArchive);
    }
}