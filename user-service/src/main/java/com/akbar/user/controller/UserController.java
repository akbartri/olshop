package com.akbar.user.controller;

import com.akbar.user.dto.DepartmentDTO;
import com.akbar.user.dto.ResponseDTO;
import com.akbar.user.dto.UserDTO;
import com.akbar.user.dto.UserWithDepartmentDTO;
import com.akbar.user.entity.User;
import com.akbar.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<ResponseDTO> findAll() {
        log.info("find all user");
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("1");
        responseDTO.setMessage("error");

        List<User> userList = userService.findAll();

        if(userList != null) {
            responseDTO.setStatus("0");
            responseDTO.setMessage("success");
            responseDTO.setContents(userList);
        }

        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> findById(@PathVariable String id) {
        log.info("find user by id");
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("1");
        responseDTO.setMessage("error");

        Optional<User> user = userService.findByUserId(Long.valueOf(id));
        if(user.isPresent()) {
            ResponseDTO responseEntity = restTemplate.getForObject("http://DEPARTMENT-SERVICE/api/department/"+user.get().getDepartmentId(),ResponseDTO.class);
            LinkedHashMap<Object,Object> lhm = (LinkedHashMap<Object,Object>) responseEntity.getContents();
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setDepartmentId((String) lhm.get("departmentId"));;
            departmentDTO.setDepartmentName((String) lhm.get("departmentName"));
            departmentDTO.setDepartmentAddress((String) lhm.get("departmentAddress"));
            departmentDTO.setDepartmentCode((String) lhm.get("departmentCode"));

            responseDTO.setStatus("0");
            responseDTO.setMessage("success");

            UserWithDepartmentDTO result = new UserWithDepartmentDTO();
            result.setUserId(user.get().getUserId().toString());
            result.setFirstName(user.get().getFirstName());
            result.setLastName(user.get().getLastName());
            result.setEmail(user.get().getEmail());
            result.setDepartmentDTO(departmentDTO);

            responseDTO.setContents(result);
        }

        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseDTO> findByEmail(@PathVariable String email) {
        log.info("find user by email");
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("1");
        responseDTO.setMessage("error");

        Optional<User> user = userService.findByEmail(email);
        if(user.isPresent()) {
            ResponseDTO responseEntity = restTemplate.getForObject("http://DEPARTMENT-SERVICE/api/department/"+user.get().getDepartmentId(),ResponseDTO.class);
            LinkedHashMap<Object,Object> lhm = (LinkedHashMap<Object,Object>) responseEntity.getContents();
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setDepartmentId((String) lhm.get("departmentId"));;
            departmentDTO.setDepartmentName((String) lhm.get("departmentName"));
            departmentDTO.setDepartmentAddress((String) lhm.get("departmentAddress"));
            departmentDTO.setDepartmentCode((String) lhm.get("departmentCode"));

            responseDTO.setStatus("0");
            responseDTO.setMessage("success");

            UserWithDepartmentDTO result = new UserWithDepartmentDTO();
            result.setUserId(user.get().getUserId().toString());
            result.setFirstName(user.get().getFirstName());
            result.setLastName(user.get().getLastName());
            result.setEmail(user.get().getEmail());
            result.setDepartmentDTO(departmentDTO);

            responseDTO.setContents(result);
        }

        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> save(@RequestBody UserDTO userDTO) {
        log.info("save user");
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("1");
        responseDTO.setMessage("error");

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setDepartmentId(Long.valueOf(userDTO.getDepartmentId()));

        String result = userService.saveOrUpdate(user);

        if(result.equals("success")) {
            responseDTO.setStatus("0");
            responseDTO.setMessage("success");
        }

        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable String id, @RequestBody UserDTO userDTO) {
        log.info("update user");
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("1");
        responseDTO.setMessage("error");

        Optional<User> findUser = userService.findByUserId(Long.valueOf(id));

        if(!findUser.isPresent()) {
            responseDTO.setStatus("1");
            responseDTO.setMessage("User not found!");
        } else {
            User user = new User();
            user.setUserId(Long.valueOf(userDTO.getUserId()));
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
            user.setDepartmentId(Long.valueOf(userDTO.getDepartmentId()));

            String result = userService.saveOrUpdate(user);

            if(result.equals("success")) {
                responseDTO.setStatus("0");
                responseDTO.setMessage("success");
            }
        }

        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteById(@PathVariable String id) {
        log.info("delete user");

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("1");
        responseDTO.setMessage("error");

        Optional<User> findUser = userService.findByUserId(Long.valueOf(id));

        if(!findUser.isPresent()) {
            responseDTO.setStatus("1");
            responseDTO.setMessage("User not found!");
        } else {
            userService.deleteById(Long.valueOf(id));
            responseDTO.setStatus("0");
            responseDTO.setMessage("success");
        }

        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
