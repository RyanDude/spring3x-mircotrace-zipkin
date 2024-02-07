package org.cloud.sample.Services;

import org.cloud.sample.Utils.JwtTool;
import org.cloud.sample.Utils.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final JwtTool jwtTool;
    @Autowired
    public AuthService(JwtTool jwtTool){
        this.jwtTool = jwtTool;
    }
    public String assign_token(JwtUser user){
        return jwtTool.generateAccessToken(user);
    }
}
