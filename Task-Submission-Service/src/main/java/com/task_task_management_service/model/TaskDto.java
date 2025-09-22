package com.task_task_management_service.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDto {
	
	
	private Long Id;
	
    private String title;
	
	private String description;
	
	private String image;
	
	private Long  assignedUserId;
	
	private  List<String> tags= new ArrayList<>() ;
	
	private TaskStatus status;
	
	private LocalDateTime deadline;
	
	private LocalDateTime createdAt;


}
