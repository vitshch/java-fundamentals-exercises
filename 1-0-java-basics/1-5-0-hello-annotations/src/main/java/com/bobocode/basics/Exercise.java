package com.bobocode.basics;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.bobocode.basics.Level.BASIC;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(TYPE)
public @interface Exercise {
    String value();
    Level complexityLevel() default BASIC;
}
