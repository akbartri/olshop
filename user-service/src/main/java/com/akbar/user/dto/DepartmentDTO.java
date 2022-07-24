package com.akbar.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
