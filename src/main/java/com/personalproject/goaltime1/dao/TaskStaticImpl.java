package com.personalproject.goaltime1.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.personalproject.goaltime1.domain.Task;

@Repository("staticTasks")
public class TaskStaticImpl implements TaskDao {

    @Override
    public List<Task> getTasks(String userName) throws IllegalArgumentException {
        List<Task> taskList = new ArrayList<Task>();
        taskList.add(new Task(1L, "Study for Certification", "Complete Chapters 1-5 of OCAJP", "Java Certification", 1, "Complete", new Date(),
                new Date(), true, userName));
        taskList.add(new Task(2L, "Run 10 Miles", "Take the Addison-White Rock Trail", "Triathlon Winner", 2, "InProgress", new Date(),
                new Date(), false, userName));
        taskList.add(new Task(3L, "Integrate Anda Account CRUD Operations", "Use Angular 2 HTTP", "Meet Expectations on Anda", 1, "Review", new Date(),
                new Date(), false, userName));
        taskList.add(new Task(4L, "Discuss 1 Peter with Community Group", "Meeting at 2pm at Watermark", "Biblically-Equipped", 1, "Pending", new Date(),
                new Date(), false, userName));

        return taskList;
    }

    @Override
    public Task getTaskById(Long id) {
        List<Task> taskList = new ArrayList<Task>();
        taskList.add(new Task(1L, "testTaskName1", "testTaskDescription1", "TestGoal1", 1, "InProgress", new Date(),
                new Date(), false, "user1"));
        taskList.add(new Task(2L, "testTaskName2", "testTaskDescription2", "TestGoal2", 2, "InProgress", new Date(),
                new Date(), false, "user1"));
        taskList.add(new Task(3L, "testTaskName3", "testTaskDescription3", "TestGoal3", 3, "Review", new Date(),
                new Date(), false, "user1"));
        taskList.add(new Task(4L, "testTaskName4", "testTaskDescription4", "TestGoal2", 1, "Completed", new Date(),
                new Date(), true, "user1"));

        Task task = null;
        for(Task individualTask : taskList) {
            if (individualTask.getId() == id) {
                task = individualTask;
            }
        }
        return task;
    }

    @Override
    public Task addTask(Task taskToAdd) {

        List<Task> taskList = new ArrayList<Task>();
        taskList.add(new Task(1L, "testTaskName1", "testTaskDescription1", "TestGoal1", 1, "InProgress", new Date(),
                new Date(), false, "user1"));
        taskList.add(new Task(2L, "testTaskName2", "testTaskDescription2", "TestGoal2", 2, "InProgress", new Date(),
                new Date(), false, "user1"));
        System.out.println("The taskList array before addTask() is called is:");
        for(Task taskBeforeAdd : taskList) {
            System.out.println(taskBeforeAdd);
        }
        System.out.println(taskList);
        System.out.println("The taskList array after addTask() is called is:");

        taskList.add(taskToAdd);
        for(Task taskAfterAdd : taskList) {
            System.out.println(taskAfterAdd);
        }
        return taskToAdd;

    }

    @Override
    public void updateTask(Task taskToUpdate) {
        // TODO Auto-generated method stub

    }

    @Override
    public void archiveTask(Task taskToArchive) {
        // TODO Auto-generated method stub

    }

}
