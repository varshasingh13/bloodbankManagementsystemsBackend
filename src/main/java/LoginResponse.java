package com.bloodBank.bbms.bbmsbackend;

import lombok.Data;

@Data
public class LoginResponse {
    String message;
    Boolean status;


    public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public LoginResponse(){

    }


    @Override
    public String toString() {
        return "LoginResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}