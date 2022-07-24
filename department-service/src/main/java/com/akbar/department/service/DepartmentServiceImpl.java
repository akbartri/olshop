package com.akbar.department.service;

import com.akbar.department.entity.Department;
import com.akbar.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public String saveOrUpdate(Department department) {
        Department saveDepartment = departmentRepository.save(department);
        return saveDepartment != null ? "success" : "error";
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> findByDepartmentId(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }

    @Override
    public String deleteById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
        return "success";
    }
}