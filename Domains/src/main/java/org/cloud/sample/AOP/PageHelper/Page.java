package org.cloud.sample.AOP.PageHelper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Page {
    private int page_number;
    private int rows_per_page;
}
