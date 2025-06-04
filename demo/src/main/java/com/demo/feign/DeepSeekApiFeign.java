package com.demo.feign;

import com.demo.feign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "deep-seek-api", url = "https://api.deepseek.com", configuration = FeignConfig.class)
public interface DeepSeekApiFeign {

    @PostMapping(value = "/chat/completions", consumes = "application/json", produces = "application/json")
    String chatCompletions(@RequestBody String requestBody);
}
