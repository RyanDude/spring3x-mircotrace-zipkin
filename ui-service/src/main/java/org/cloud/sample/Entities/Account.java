package org.cloud.sample.Entities;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    private int id;
    private String email;
    private String name;
    private LocalDateTime createTime;
}
