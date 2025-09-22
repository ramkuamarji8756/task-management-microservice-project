package com.task_task_management_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task_task_management_service.model.Submission;
import java.util.List;


public interface SubmissionRepository  extends JpaRepository<Submission, Long>{

	List<Submission> findByTaskId(Long taskId);
}
