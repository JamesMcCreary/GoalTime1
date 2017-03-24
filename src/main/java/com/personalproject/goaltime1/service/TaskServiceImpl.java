package com.personalproject.goaltime1.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalproject.goaltime1.dao.TaskDao;
import com.personalproject.goaltime1.dao.TaskJPADao;
import com.personalproject.goaltime1.domain.Task;

@Service("taskService")
//@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class TaskServiceImpl implements TaskService {

    @Resource(name="staticTasks")
    private TaskDao taskDao;

    //@Resource(name="jpaTasks")
    @Autowired
    private TaskJPADao taskJpaDao;

    @Override
    public List<Task> getTasks(String userName) {
        //        return taskDao.getTasks(userName);

        List<Task> results = taskJpaDao.findAll();
        //List<Task> results = taskDao.getTasks(userName);
        System.out.println(results);
        return results;
    }

    @Override
    public Task getTaskById(Long id) {
        return taskDao.getTaskById(id);
    }
    //    For use with $http in front-end
    //    @Override
    //    public void addTask(Task taskToAdd) {
    //        taskDao.addTask(taskToAdd);
    //    }

    @Override
    public Task addTask(Task taskToAdd) {
        return taskDao.addTask(taskToAdd);
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