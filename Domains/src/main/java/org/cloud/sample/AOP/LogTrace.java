package org.cloud.sample.AOP;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * request tracing
 * LOG FORMAT: [service_name, traceId, spanId]
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogTrace {
}
