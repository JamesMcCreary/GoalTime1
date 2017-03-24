package com.personalproject.goaltime1.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.personalproject.goaltime1.domain.Task;

@Repository("taskDao")
public class TaskDaoImpl implements TaskDao {

    //    @Resource
    //    private SessionFactory sessionFactory;
    //
    //    @Resource
    //    private JdbcOperations jdbcOperations;

    @SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
    @Override
    public List<Task> getTasks(String userName) throws IllegalArgumentException {

        String sqlWithoutArchived = "SELECT *" +
                " FROM TASK_LIST" +
                " WHERE USERNAME = :userName AND ARCHIVED = FALSE";

        List<Task> taskList = new ArrayList<Task>();

        //        Query query = sessionFactory.getCurrentSession().createSQLQuery(sqlWithoutArchived)
        //                .addEntity(Task.class)
        //                .setParameter("userName", userName);

        //        taskList =  query.list();
        return taskList;


        //        try {
        //            Session session = sessionFactory.openSession();
        //            //
        //            //            @SuppressWarnings("unchecked")
        //            //            TypedQuery<Task> query = session.createQuery(sql);
        //            //            taskList = query.getResultList();
        //            //            session.close();
        //
        //            @SuppressWarnings("deprecation")
        //            Criteria cr = session.createCriteria(Task.class);
        //            cr.add(Restrictions.eq("USERNAME", userName))
        //            .add(Restrictions.eq("ARCHIVED", false));
        //
        //            taskList = cr.list();
        //
        //
        //            //            for (Object oneObject : session.createQuery(sql)
        //            //                    .setParameter("userName", userName)
        //            //                    .getResultList()) {
        //            //                taskList.add((Task)oneObject);
        //
        //        } catch (IllegalArgumentException e) {
        //            e.printStackTrace();
        //        }
        //return taskList;
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    @Override
    public Task getTaskById(Long id) {

        String sql = "SELECT *" +
                " FROM TASK_LIST" +
                " WHERE ID = :id AND ARCHIVED = FALSE";

        //Session session = sessionFactory.openSession();

        //        @SuppressWarnings("unchecked")
        //        List<Task> results = session.createQuery(sql)
        //        .setParameter("id",  id)
        //        .getResultList();

        /*
        @SuppressWarnings("unchecked")
        TypedQuery<Task> query = session.createQuery(sql);
        List<Task> results = query.getResultList();
        session.close();
         */

        //        Criteria cr = session.createCriteria(Task.class);
        //        cr.add(Restrictions.eq("ID", id))
        //        .add(Restrictions.eq("ARCHIVED", false));

        @SuppressWarnings("rawtypes")
        //        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql)
        //        .addEntity(Task.class)
        //        .setParameter("id", id);
        //
        List<Task> taskList = Collections.emptyList(); //query.list();




        return taskList.size() > 0 ? taskList.get(0) : null;
    }

    @Override
    public Task addTask(Task taskToAdd) {
        //        sessionFactory.getCurrentSession().saveOrUpdate(taskToAdd);

        return taskToAdd;
    }

    @Override
    public void updateTask(Task taskToUpdate) {
        //        sessionFactory.getCurrentSession().saveOrUpdate(taskToUpdate);
    }

    @Override
    public void archiveTask(Task taskToArchive) {
        //        sessionFactory.getCurrentSession().saveOrUpdate(taskToArchive);
    }
}
