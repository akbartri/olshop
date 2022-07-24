package com.akbar.department.controller;

import com.akbar.department.dto.DepartmentDTO;
import com.akbar.department.dto.ResponseDTO;
import com.akbar.department.entity.Department;
import com.akbar.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<ResponseDTO> findAllDepartment() {
        log.info("find all department");
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("1");
        responseDTO.setMessage("Error");

        List<Department> departmentList = departmentService.findAll();
        if(departmentList != null && departmentList.size() > 0) {
            responseDTO.setStatus("0");
            responseDTO.setMessage("success");
            responseDTO.setContents(departmentList);
        }

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> findDepartmentById(@PathVariable String id) {
        log.info("find department by id");
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("1");
        responseDTO.setMessage("Error");

        Optional<Department> department = departmentService.findByDepartmentId(Long.valueOf(id));
        if(department.isPresent()) {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setDepartmentId(department.get().getDepartmentId().toString());
            departmentDTO.setDepartmentName(department.get().getDepartmentName());
            departmentDTO.setDepartmentCode(department.get().getDepartmentCode());
            departmentDTO.setDepartmentAddress(department.get().getDepartmentAddress());

            responseDTO.setStatus("0");
            responseDTO.setMessage("success");
            responseDTO.setContents(departmentDTO);
        }

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
        log.info("save department");
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("1");
        responseDTO.setMessage("Error");

        Department department = new Department();
        department.setDepartmentCode(departmentDTO.getDepartmentCode());
        department.setDepartmentName(departmentDTO.getDepartmentName());
        department.setDepartmentAddress(departmentDTO.getDepartmentAddress());

        String result = departmentService.saveOrUpdate(department);

        if(result.equals("success")) {
            responseDTO.setStatus("0");
            responseDTO.setMessage("save success");
        }

        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateDepartment(@PathVariable String id, @ModelAttribute DepartmentDTO departmentDTO) {
        log.info("update department");
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("1");
        responseDTO.setMessage("Error");

        Optional<Department> department = departmentService.findByDepartmentId(Long.valueOf(id));

        if(!department.isPresent()) {
            responseDTO.setStatus("404");
            responseDTO.setMessage("Department Not Found");
        } else {
            Department updateDepartment = new Department();
            updateDepartment.setDepartmentId(Long.valueOf(departmentDTO.getDepartmentId()));
            updateDepartment.setDepartmentCode(departmentDTO.getDepartmentCode());
            updateDepartment.setDepartmentName(departmentDTO.getDepartmentName());
            updateDepartment.setDepartmentAddress(departmentDTO.getDepartmentAddress());

            String result = departmentService.saveOrUpdate(updateDepartment);

            if(result.equals("success")) {
                responseDTO.setStatus("0");
                responseDTO.setMessage("update success");
            }
        }

        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteDepartmentById(@PathVariable String id) {
        log.info("delete department");
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("1");
        responseDTO.setMessage("Error");

        Optional<Department> department = departmentService.findByDepartmentId(Long.valueOf(id));

        if(!department.isPresent()) {
            responseDTO.setStatus("404");
            responseDTO.setMessage("Department Not Found");
        } else {
            String result = departmentService.deleteById(Long.valueOf(id));

            if(result.equals("success")) {
                responseDTO.setStatus("0");
                responseDTO.setMessage("delete success");
            } else {
                responseDTO.setStatus("1");
                responseDTO.setMessage("delete failed");
            }
        }

        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
