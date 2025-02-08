package com.matheusmaciel.service.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class TaskNotificationSchedule {
  
    private final TaskService taskService;

    public TaskNotificationSchedule(TaskService taskService) {
        this.taskService = taskService;
    }
    @Scheduled(fixedRate = 60)
    public void checkAndNotifyTasks(){
        this.taskService.sendNotificationForDueTasks();
    }
}