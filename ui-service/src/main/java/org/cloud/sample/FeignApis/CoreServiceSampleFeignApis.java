package org.cloud.sample.FeignApis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "core-service-sample", url = "http://localhost:10001")
public interface CoreServiceSampleFeignApis {
    @GetMapping("/api/hi")
    String hi();
}
