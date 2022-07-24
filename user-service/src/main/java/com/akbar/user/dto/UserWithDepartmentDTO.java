package com.akbar.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserWithDepartmentDTO {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private DepartmentDTO departmentDTO;
}
