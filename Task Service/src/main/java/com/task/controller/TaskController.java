package com.task.controller;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.model.Task;
import com.task.model.TaskStatus;
import com.task.model.UserDto;
import com.task.service.TaskService;
import com.task.service.UserService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping()
	public ResponseEntity<Task> createTask(@RequestBody Task task,
			@RequestHeader("Authorization") String jwt) throws Exception{
		
		UserDto user = userService.getUserProfile(jwt);
		
		  Task createdTask = taskService.createTask(task, user.getRole());
		return new ResponseEntity<Task>(createdTask,HttpStatus.CREATED);
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id,
			                               @RequestHeader("Authorization") String jwt) throws Exception{
		
		UserDto user = userService.getUserProfile(jwt);
		
		  Task task = taskService.getTaskById(id);
		return new ResponseEntity<Task>(task,HttpStatus.OK);
		
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<Task>> getAssignUserTask(
			                               @RequestParam(required = false)TaskStatus status,
			                               @RequestHeader("Authorization") String jwt) throws Exception{
		
		UserDto user = userService.getUserProfile(jwt);
		
		  List<Task> tasks = taskService.assignedUsersTask(user.getId(), status);
		return new ResponseEntity<>(tasks,HttpStatus.OK);
		
	}
	
/*	@GetMapping()
	public ResponseEntity<List<Task>> getAllTask(
			                               @RequestParam(required = false)TaskStatus status,
			                               @RequestHeader("Authorization") String jwt) throws Exception{
		
		UserDto user = userService.getUserProfile(jwt);
		
		  List<Task> tasks = taskService.getAllTask(status);
				  
		return new ResponseEntity<>(tasks,HttpStatus.OK);
		
	} */
	
	@GetMapping
	public ResponseEntity<List<Task>> getAllTask(
	    @RequestParam(value = "status", required = false) String status,
	    @RequestHeader("Authorization") String jwt) throws Exception {

	    UserDto user = userService.getUserProfile(jwt);

	    TaskStatus taskStatus = null;
	    if (status != null) {
	        try {
	            taskStatus = TaskStatus.valueOf(status.toUpperCase());
	        } catch (IllegalArgumentException e) {
	            throw new BadRequestException("Invalid status value: " + status);
	        }
	    }

	    List<Task> tasks = taskService.getAllTask(taskStatus);

	    return new ResponseEntity<>(tasks, HttpStatus.OK);
	}

	                                   //taskid //userid
	// http://localhost:5002/api/tasks/52/user/52/assigned
	@PutMapping("/{id}/user/{userid}/assigned")
	public ResponseEntity<Task> assignedTaskToUser(
			                              @PathVariable("id") Long id ,
			                              @PathVariable("userid") Long userid,
			                               @RequestHeader("Authorization") String jwt) throws Exception{
		
		UserDto user = userService.getUserProfile(jwt);
		
		  Task tasks = taskService.assignedToUser(userid, id);
				  
		return new ResponseEntity<>(tasks,HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(
			                              @PathVariable("id") Long id ,
			                             @RequestBody Task req,
			                               @RequestHeader("Authorization") String jwt) throws Exception{
		
		UserDto user = userService.getUserProfile(jwt);
		
		  Task tasks = taskService.updateTask(id, req, id);
				  
		return new ResponseEntity<>(tasks,HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}/complete")
	public ResponseEntity<Task> completeTask(
			                              @PathVariable("id") Long id ) throws Exception{
		
		
		
		  Task tasks = taskService.completeTask(id);
				  
		return new ResponseEntity<>(tasks,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(
			                              @PathVariable("id") Long id ) throws Exception{
		
		
		
		taskService.deletedTask(id);
				  
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	
}
