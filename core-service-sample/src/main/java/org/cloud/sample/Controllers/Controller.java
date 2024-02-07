package org.cloud.sample.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.cloud.sample.AOP.LogTrace;
import org.cloud.sample.Services.SecurityService;
import org.cloud.sample.Utils.JwtUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class Controller {
    private final SecurityService securityService;
    public Controller(SecurityService securityService){
        this.securityService = securityService;
    }
    @GetMapping("/hi")
    @LogTrace
    public String hi(){
        return "hi";
    }
    @GetMapping("/token")
    public String token(){
        return this.securityService.token(JwtUser.builder().enabled(true).id(1).username("jguo").authorities(List.of("admin", "user")).build());
    }
}
