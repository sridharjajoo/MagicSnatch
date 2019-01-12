package com.example.sridharjajoo.magicsnatch.data;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequest {

    public String userName;
    public String password;
}
