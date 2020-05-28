package com.zhuweiwei.eurekaconsumer.annotation;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface RibbonAnnotation {
}
