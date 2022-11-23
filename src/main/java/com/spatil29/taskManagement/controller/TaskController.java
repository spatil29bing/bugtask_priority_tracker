package com.spatil29.taskManagement.controller;

import com.spatil29.taskManagement.model.Task;
import com.spatil29.taskManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task)
    {
        return taskService.addTask(task);
    }
    @GetMapping
    public List<Task> getTasks()
    {
        return taskService.findAllTasks();
    }
    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable String taskId){
        return taskService.getTaskByTaskId(taskId);

    }

    @GetMapping("/severity/{severity}")
    public List<Task> findTaskUsingSeverity(@PathVariable int severity)
    {
        return taskService.getTaskBySeverity(severity);
    }

    @GetMapping("/assignee/{severity}")
    public List<Task> findTaskUsingAssignee(@PathVariable String assignee)
    {
        return taskService.getTaskByAssignee(assignee);
    }
    @GetMapping("/severity/lt/{severity}")
    public List<Task> findTaskByLessThanSeverity(@PathVariable int severity)
    {
        return taskService.findTaskByLessThanSeverity(severity);
    }
    @GetMapping("/severity/gt/{severity}")
    public List<Task> findTaskByGreaterThanSeverity(@PathVariable int severity)
    {
        return taskService.findTaskByGreaterThanSeverity(severity);
    }
    @GetMapping("/get")
    public List<Task> findTaskBySeverityAndAssignee(@RequestParam int severity, @RequestParam String assignee)
    {
        return taskService.findTaskBySeverityAndAssignee(severity, assignee);
    }
    @PutMapping
    public Task modifyTask(@RequestBody Task taskRequest)
    {

        return taskService.updateTask(taskRequest);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId)
    {
        return taskService.deleteTask(taskId);
    }

}
