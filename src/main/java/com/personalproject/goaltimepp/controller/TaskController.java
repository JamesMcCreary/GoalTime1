package com.personalproject.goaltimepp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.personalproject.goaltimepp.domain.Task;
import com.personalproject.goaltimepp.service.TaskService;

@RestController
public class TaskController {

    @Resource
    private TaskService taskService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testString() {
        return "Great, I'll head over in a few!";
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<Task> getTasks() {
        String userName = "user1";
        return taskService.getTasks(userName);
    }

    @RequestMapping(value = "/getTaskById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Task getTaskById(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    @ResponseBody
    public void addTask(@RequestBody Task taskToAdd) {
        taskService.addTask(taskToAdd);
    }

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