package com.matheusmaciel.service.tasks;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<TasksEntity, Long> {
}