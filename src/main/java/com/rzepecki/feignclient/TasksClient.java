package com.rzepecki.feignclient;

import com.rzepecki.feignclient.pojo.Task;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "tasksClient",
        url = "https://jsonplaceholder.typicode.com")
public interface TasksClient {
    @GetMapping(value = "/todos")
    List<Task> getTasksBy(@RequestParam("userId") Integer userId);

}
