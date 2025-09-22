package com.task_task_management_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.task_task_management_service.model.TaskDto;

@FeignClient(name ="SUBMISSION-SERVICE" ,url = "http://localhost:5002/")
public interface TaskService {
	
	@GetMapping("/api/tasks/{id}")
	public TaskDto getTaskById(@PathVariable("id") Long id,
			                               @RequestHeader("Authorization") String jwt) throws Exception;
	
	
	@PutMapping("/api/tasks/{id}/complete")
	public TaskDto completeTask(
			                              @PathVariable("id") Long id ) throws Exception;
		
	

}
