package com.akbar.auth.service;

import com.akbar.auth.dto.LoginDTO;
import com.akbar.auth.dto.RequestDTO;
import com.akbar.auth.dto.ResponseDTO;
import com.akbar.auth.dto.TokenDTO;
import com.akbar.auth.dto.vo.UserVO;
import com.akbar.auth.utility.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JWTUtil jwtUtil;

    public ResponseDTO register(RequestDTO requestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("1");
        responseDTO.setMessage("error");

        requestDTO.setPassword(BCrypt.hashpw(requestDTO.getPassword(), BCrypt.gensalt()));

        return restTemplate.postForObject("http://user-service/api/users",requestDTO,ResponseDTO.class);
    }

    public ResponseDTO login(LoginDTO loginDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("1");
        responseDTO.setMessage("error");

//        responseDTO = restTemplate.getForObject("http://user-service/api/users/email/"+loginDTO.getEmail(),ResponseDTO.class);

        UserVO userVO = new UserVO();
        userVO.setEmail(loginDTO.getEmail());
        userVO.setId("1");
        userVO.setRole("ADMIN");
        userVO.setPassword(loginDTO.getPassword());

        if (responseDTO.getStatus().equals("0")) {
//            responseDTO.setContents(new TokenDTO(jwtUtil.generate(userVO,"ACCESS")));
        }

        return responseDTO;
    }
}
