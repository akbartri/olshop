package com.akbar.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private String password;
}
