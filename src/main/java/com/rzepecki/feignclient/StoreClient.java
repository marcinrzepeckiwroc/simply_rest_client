package com.rzepecki.feignclient;


import com.rzepecki.feignclient.pojo.User;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "StoreClient", url = "https://jsonplaceholder.typicode.com/")
public interface StoreClient {

    @GetMapping("/users")
    List<User> users();

}
