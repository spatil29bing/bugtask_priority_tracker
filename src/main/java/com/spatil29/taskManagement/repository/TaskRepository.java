package com.spatil29.taskManagement.repository;

import com.spatil29.taskManagement.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String > {
    List<Task> findBySeverity(int severity);
    List<Task> findTaskByAssignee(String  assignee);
    @Query("{severity: {$lte :?0 }}")
    List<Task> findTaskByLessThanSeverity(int severity);
    @Query("{severity: {$gt :?0 }}")
    List<Task> findTaskByGreaterThanSeverity(int severity);

    @Query("{'severity' : ?0 , 'assignee' : ?1}")
    List<Task> findTaskBySeverityAndAssignee(int severity, String assignee);
}
