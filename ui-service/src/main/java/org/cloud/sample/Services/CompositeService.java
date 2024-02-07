package org.cloud.sample.Services;

import org.cloud.sample.Entities.Account;
import org.cloud.sample.FeignApis.CoreServiceSampleFeignApis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class CompositeService {
    private final CoreServiceSampleFeignApis coreServiceSampleFeignApis;
    private final RestTemplate restTemplate;
    @Autowired
    public CompositeService(CoreServiceSampleFeignApis coreServiceSampleFeignApis, RestTemplate restTemplate){
        this.coreServiceSampleFeignApis = coreServiceSampleFeignApis;
        this.restTemplate = restTemplate;
    }
    public String login(){
        return this.coreServiceSampleFeignApis.login(Account.builder().email("guotajun@gmail.com").password("123").build());
    }
    public String test(){
        return this.restTemplate.getForObject("http://localhost:10001/auth/login", String.class);
    }
}
