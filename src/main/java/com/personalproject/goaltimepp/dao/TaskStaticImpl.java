package com.personalproject.goaltimepp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.personalproject.goaltimepp.domain.Task;

@Repository("staticTasks")
public class TaskStaticImpl implements TaskDao {

    @Override
    public List<Task> getTasks(String userName) throws IllegalArgumentException {
        List<Task> list = new ArrayList<Task>();
        list.add(new Task(34L, "testname", "task descript", "goal1", 1, "open", new Date(),
                new Date(), false, userName) );
        return list;
    }

    @Override
    public Task getTaskById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addTask(Task taskToAdd) {
        // TODO Auto-generated method stub

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
