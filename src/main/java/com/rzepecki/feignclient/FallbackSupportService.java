package com.rzepecki.feignclient;

import com.rzepecki.feignclient.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class FallbackSupportService {

    private final UsersProvider usersProvider;
    private final Printer printResultService;

    public FallbackSupportService(UsersProvider usersProvider,
                                  Printer printResultService) {
        this.usersProvider = usersProvider;
        this.printResultService = printResultService;
    }

    private List<User> backupUsers = null;

    void getUsersAndPrint() {
        backupUsers = usersProvider.getUsersWithTasks();
        printResultService.printUsersWithTasks(backupUsers);
    }

    @SuppressWarnings("unused")
    public void printCachedResults() {
        if (null != backupUsers) {
            log.warn("Current data are from backup!");
            printResultService.printUsersWithTasks(backupUsers);
        } else {
            log.error("No results... try again later...");
        }
    }
}
