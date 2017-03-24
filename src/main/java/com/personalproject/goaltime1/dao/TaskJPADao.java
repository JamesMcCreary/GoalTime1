package com.personalproject.goaltime1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personalproject.goaltime1.domain.Task;

@Repository("jpaTasks")
public interface TaskJPADao extends CrudRepository<Task, Long> {

    @Modifying
    List<Task> findAll();

}


