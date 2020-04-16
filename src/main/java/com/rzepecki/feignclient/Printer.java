package com.rzepecki.feignclient;

import com.rzepecki.feignclient.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@Slf4j
public class Printer {
    void printUsersWithTasks(List<User> users) {
        users.stream().forEach(user -> {
            log.info(MessageFormat.format("User #{0} ({1})",
                    user.getId(),
                    user.getUsername()));
            printTasksFor(user);
        });
    }
    private void printTasksFor(User user) {
        user
                .getTasks()
                .stream()
                .map(task -> MessageFormat.format("\t[{0}] task: {1}])",
                        task.getCompleted() ? "*" : " ",
                        task.getTitle())).forEach(log::info);
    }
}
