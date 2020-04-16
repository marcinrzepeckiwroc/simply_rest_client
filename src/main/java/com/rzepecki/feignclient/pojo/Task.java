package com.rzepecki.feignclient.pojo;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    Integer id;
    Integer userId;
    String title;
    Boolean completed;
}
