package com.spatil29.taskManagement.service;

import com.spatil29.taskManagement.model.Task;
import com.spatil29.taskManagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    //CRUD

    public Task addTask(Task task)
    {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return taskRepository.save(task);
    }

    public List<Task> findAllTasks()
    {
       return taskRepository.findAll();
    }

    public Task getTaskByTaskId(String taskId){
        return taskRepository.findById(taskId).get();

    }
    public List<Task> getTaskBySeverity(int severity)
    {
        return taskRepository.findBySeverity(severity);
    }

    public List<Task> getTaskByAssignee(String assignee)
    {
        return taskRepository.findTaskByAssignee(assignee);
    }

    public Task updateTask(Task taskRequest)
    {
        //get existing document from db
        //populate new value from request to existing document
        Task existingTask = taskRepository.findById(taskRequest.getTaskId()).get();
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setSeverity(taskRequest.getSeverity());
        existingTask.setAssignee(taskRequest.getAssignee());
        existingTask.setStoryPoint(taskRequest.getStoryPoint());
        return taskRepository.save(existingTask);
    }

    public String deleteTask(String taskId)
    {
        taskRepository.deleteById(taskId);
        return taskId+ " Task deleted from dashboard";
    }

    public List<Task> findTaskByLessThanSeverity(int severity) {
        return taskRepository.findTaskByLessThanSeverity(severity);
    }

    public List<Task> findTaskByGreaterThanSeverity(int severity) {
        return taskRepository.findTaskByGreaterThanSeverity(severity);
    }

    public List<Task> findTaskBySeverityAndAssignee(int severity, String assignee)
    {
        return taskRepository.findTaskBySeverityAndAssignee(severity,assignee);
    }

}
