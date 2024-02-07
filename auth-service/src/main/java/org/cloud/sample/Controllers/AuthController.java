package org.cloud.sample.Controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.cloud.sample.AOP.LogTrace;
import org.cloud.sample.Entities.Account;
import org.cloud.sample.RespDto;
import org.cloud.sample.Services.AccountService;
import org.cloud.sample.Services.AuthService;
import org.cloud.sample.Utils.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final AccountService accountService;
    @Autowired
    public AuthController(AuthService authService, AccountService accountService){
        this.authService = authService;
        this.accountService = accountService;
    }
    @PostMapping("/test")
    @LogTrace
    public String test(){
        return this.authService.assign_token(JwtUser.builder().enabled(true).password("123").id(1).username("jguo").authorities(List.of("admin","user")).build());
    }
    @PostMapping("/login")
    @LogTrace
    public String login(
            @RequestBody Account account
    ){
        // email and password matched
        boolean matched = this.accountService.email_pass_match(account.getEmail(), account.getPassword());
        if(!matched){return "email/password not matched";}
        // if login success, then add cookie
        String token = this.authService.assign_token(JwtUser.builder().id(1).authorities(List.of("admin", "user")).username("jguo").password("123456").build());
        HttpServletResponse response =
                ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                        .getResponse();
        Cookie cookie = new Cookie("my_token", token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(cookie);
        return token;
    }
    @PostMapping("/reg")
    public RespDto reg(@RequestBody Account account){
        try {
            this.accountService.createAccount(account);
            return RespDto.builder().msg("success").status_code("200").build();
        }catch (Exception e){
            return RespDto.builder().msg("duplicated email").status_code("400").build();
        }
    }
}
