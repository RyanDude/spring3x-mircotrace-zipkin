package org.cloud.sample.FeignApis;

import org.cloud.sample.Entities.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-service", url = "http://localhost:10001")
public interface CoreServiceSampleFeignApis {
    @PostMapping ("/auth/login")
    String login(@RequestBody Account account);
}
