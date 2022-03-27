package com.webcontroller.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private String userId;
    private String userFullName;
    private String userPassword;
    private boolean active;
    private String userRole;
}
