package org.cloud.sample.Services;

import org.cloud.sample.FeignApis.CoreServiceSampleFeignApis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompositeService {
    private final CoreServiceSampleFeignApis coreServiceSampleFeignApis;
    private final RestTemplate restTemplate;
    @Autowired
    public CompositeService(CoreServiceSampleFeignApis coreServiceSampleFeignApis, RestTemplate restTemplate){
        this.coreServiceSampleFeignApis = coreServiceSampleFeignApis;
        this.restTemplate = restTemplate;
    }
    public String hi(){
        return this.coreServiceSampleFeignApis.hi();
    }
    public String test(){
        return this.restTemplate.getForObject("http://localhost:10001/api/hi", String.class);
    }
}
