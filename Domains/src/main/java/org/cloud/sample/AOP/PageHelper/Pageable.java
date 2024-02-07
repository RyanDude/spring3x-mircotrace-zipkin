package org.cloud.sample.AOP.PageHelper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * detect the Page Object from the arguments
 * convert page_number and rows_per_page to start,offset
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Pageable {
}
