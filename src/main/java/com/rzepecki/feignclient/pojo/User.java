package com.rzepecki.feignclient.pojo;



import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Integer id;
    String name;
    String username;
    String email;
    String phone;
    String website;

    List<Task> tasks; // here is the change
}
