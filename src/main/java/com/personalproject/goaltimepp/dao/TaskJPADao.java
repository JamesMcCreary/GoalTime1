package com.personalproject.goaltimepp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personalproject.goaltimepp.domain.Task;

@Repository("jpaTasks")
public interface TaskJPADao extends CrudRepository<Task, Long> {

    List<Task> findAll();

}


