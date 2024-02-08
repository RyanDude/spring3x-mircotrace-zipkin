package org.cloud.sample.AOP.PageHelper;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Page {
    private int page_number;
    private int rows_per_page;
    private int start;
    private int offset;
}
