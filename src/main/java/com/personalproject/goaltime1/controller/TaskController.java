package com.personalproject.goaltime1.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.personalproject.goaltime1.domain.Task;
import com.personalproject.goaltime1.domain.User;
import com.personalproject.goaltime1.service.TaskService;
import com.personalproject.goaltime1.service.UserService;

@RestController
public class TaskController {

    @Resource
    private TaskService taskService;

    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/taskList", method = RequestMethod.GET)
    public List<Task> getTasks() {
        String userName = "user1";
        User user = new User("user1","password1");
        userService.saveUser(user);

        return taskService.getTasks(userName);
    }

    @RequestMapping(value = "/getTaskById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Task getTaskById(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    // For use with $http in front-end
    //    public void addTask(@RequestBody Task taskToAdd) {
    //        taskService.addTask(taskToAdd);
    //    }

    public Task addTask(@RequestBody Task taskToAdd) {
        //        Task taskResponse = new Task(5L, "testTaskName5", "testTaskDescription5", "TestGoal5", 2, "Completed", new Date(),
        //                new Date(), false, "user1");
        //String response = "HELLO FROM THE BACKEND!";
        return taskService.addTask(taskToAdd);
    }
    //    public Task addTask() {
    ////        Task taskToAdd = new Task(5L, "testTaskName5", "testTaskDescription5", "TestGoal5", 2, "Completed", new Date(),
    ////                new Date(), false, "user1");
    ////        return taskService.addTask(taskToAdd);
    //    }

    @RequestMapping(value = "/updateTask", method = RequestMethod.POST)
    @ResponseBody
    public void updateTask(@RequestBody Task taskToUpdate) {
        taskService.updateTask(taskToUpdate);
    }

    @RequestMapping(value = "/archiveTask", method = RequestMethod.POST)
    @ResponseBody
    public void archiveTask(@RequestBody Task taskToArchive) {
        taskService.archiveTask(taskToArchive);
    }
}