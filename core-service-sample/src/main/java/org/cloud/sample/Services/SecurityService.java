package org.cloud.sample.Services;

import org.cloud.sample.Utils.JwtTool;
import org.cloud.sample.Utils.JwtUser;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    private final JwtTool jwtTool;
    public SecurityService(JwtTool jwtTool){
        this.jwtTool = jwtTool;
    }
    public String token(JwtUser user){
        return this.jwtTool.generateAccessToken(user);
    }
}
