package org.cloud.sample.Utils;

import lombok.*;
import java.util.List;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JwtUser {
    private long id;
    private String username;
    private String password;
    private boolean enabled;
    private List<String> authorities;
}
