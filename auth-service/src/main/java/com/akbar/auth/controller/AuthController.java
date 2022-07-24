package com.akbar.auth.controller;

import com.akbar.auth.dto.LoginDTO;
import com.akbar.auth.dto.RequestDTO;
import com.akbar.auth.dto.ResponseDTO;
import com.akbar.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RequestDTO requestDTO) {
        ResponseDTO responseDTO = authService.register(requestDTO);

        if(responseDTO.getStatus().equals("1")) {
            return new ResponseEntity<>(responseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(responseDTO,HttpStatus.OK);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        ResponseDTO responseDTO = authService.login(loginDTO);

        if(responseDTO.getStatus().equals("1")) {
            return new ResponseEntity<>(responseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(responseDTO,HttpStatus.OK);
        }
    }

    @GetMapping("/notsecured")
    public ResponseEntity<?> notsecured() {
        return new ResponseEntity<>("not secured",HttpStatus.OK);
    }

    @GetMapping("/secured")
    public ResponseEntity<?> secured() {
        return new ResponseEntity<>("not secured",HttpStatus.OK);
    }
}
