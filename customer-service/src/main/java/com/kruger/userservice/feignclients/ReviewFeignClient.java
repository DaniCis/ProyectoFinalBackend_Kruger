package com.kruger.userservice.feignclients;

import com.kruger.userservice.model.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "product-service", url="http://localhost:8081", path = "/review")
public interface ReviewFeignClient {
    @RequestMapping(method = RequestMethod.POST , produces = "application/json")
    Review save(@RequestBody Review review);
}
