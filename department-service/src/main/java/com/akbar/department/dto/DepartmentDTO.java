package com.akbar.department.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
