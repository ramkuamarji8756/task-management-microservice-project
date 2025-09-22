package com.task_task_management_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
	
	private Long id;
    private String password;
	private String email;
	private String role;
	private String fullName;
	


}
