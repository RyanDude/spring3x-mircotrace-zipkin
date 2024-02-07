package org.cloud.sample.Entities;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Account implements Serializable {
    private int id;
    private String email;
    private String name;
    private String password;
}
