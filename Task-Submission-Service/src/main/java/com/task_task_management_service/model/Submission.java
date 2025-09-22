package com.task_task_management_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Submission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long Id;
	
	private Long taskId;
	
	private String githubLink;
	
	private Long userId;
	
	private String  status="PENDING";
	
	private LocalDateTime submissionTime;
	
	
	
}
