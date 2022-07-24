package com.akbar.auth.dto.vo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserVO {
    private String id;
    private String email;
    private String password;
    private String role;
}