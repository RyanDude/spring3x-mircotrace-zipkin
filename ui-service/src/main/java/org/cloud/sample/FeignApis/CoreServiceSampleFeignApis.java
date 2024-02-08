package org.cloud.sample.FeignApis;

import org.cloud.sample.Entities.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "auth-service", url = "http://localhost:10001")
public interface CoreServiceSampleFeignApis {
    @PostMapping ("/auth/login")
    String login(@RequestBody Account account);
    @GetMapping("/auth/test")
    List<Account> test(@RequestParam("page_number") int page_number, @RequestParam("rows_per_page")int rows_per_page);
}
