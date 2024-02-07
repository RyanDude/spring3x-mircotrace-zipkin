package org.cloud.sample.Controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.cloud.sample.AOP.LogTrace;
import org.cloud.sample.Services.CompositeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

@RestController
@RequestMapping("/api")
@Slf4j
public class UIController {
    private final CompositeService compositeService;
    @Autowired
    public UIController(CompositeService compositeService){
        this.compositeService = compositeService;
    }
    @GetMapping("/cookie_test")
    @LogTrace
    public String cookie_test(){
        HttpServletRequest request =
                ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                        .getRequest();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("my_token")){
                System.err.println(cookie.getValue());
            }
        }
        return this.compositeService.login();
    }
}
