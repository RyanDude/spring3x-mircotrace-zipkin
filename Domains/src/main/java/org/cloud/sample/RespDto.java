package org.cloud.sample;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RespDto<T> {
    private String status_code;
    private String msg;
    private T content;
}
