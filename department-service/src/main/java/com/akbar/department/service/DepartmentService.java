package com.akbar.department.service;

import com.akbar.department.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    String saveOrUpdate(Department department);
    List<Department> findAll();
    Optional<Department> findByDepartmentId(Long departmentId);
    String deleteById(Long departmentId);
}