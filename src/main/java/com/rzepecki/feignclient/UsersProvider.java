package com.rzepecki.feignclient;


import com.rzepecki.feignclient.pojo.Task;
import com.rzepecki.feignclient.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersProvider {

    @Autowired
    private StoreClient storeClient;
    @Autowired
    private TasksClient tasksClient;

    public UsersProvider() {
    }

    public List<User> getUsersWithTasks(){
        List<User> userList = storeClient.users();
        for (User user: userList) {
            List<Task> taskList = tasksClient.getTasksBy(user.getId());
            user.setTasks(taskList);
        }
        userList.forEach(System.out::println);
        return userList;
    }


}
