package com.task.service;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.task.model.Task;
import com.task.model.TaskStatus;

public interface TaskService {
	
	Task createTask(Task task, String requesterRole) throws Exception;
	
    Task getTaskById(Long id) throws Exception;
    
    
    // 
    @Query("SELECT t FROM Task t WHERE t.status = :status")
    List<Task> getAllTask( @Param("status") TaskStatus status);
    
    Task updateTask(Long id, Task updatedTask, Long userId) throws Exception;
    
    void deletedTask(Long id) throws Exception;
    
    Task assignedToUser(Long userId,Long taskId) throws Exception;
    
    List<Task> assignedUsersTask(Long userId, TaskStatus status);
    
    Task completeTask(Long taskId) throws Exception;
 	
}
