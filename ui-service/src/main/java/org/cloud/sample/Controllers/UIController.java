package org.cloud.sample.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.cloud.sample.AOP.LogTrace;
import org.cloud.sample.Entities.Account;
import org.cloud.sample.RespDto;
import org.cloud.sample.Services.CompositeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class UIController {
    private final CompositeService compositeService;
    @Autowired
    public UIController(CompositeService compositeService){
        this.compositeService = compositeService;
    }
    @GetMapping("/hi")
    @LogTrace
    public String hi(){
        return this.compositeService.test();
    }
    @GetMapping("/test")
    public RespDto test(){
        return RespDto.builder().content(List.of(Account.builder().createTime(LocalDateTime.now()).build())).build();
    }
}
