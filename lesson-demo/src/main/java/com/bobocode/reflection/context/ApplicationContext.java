package com.bobocode.reflection.context;

import com.bobocode.reflection.context.annotation.Component;
import com.bobocode.util.ExerciseNotCompletedException;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ApplicationContext {

    private Map<String, Object> beanMap = new HashMap<>();

    public ApplicationContext(String basePackage) {
        var reflections = new Reflections(basePackage);
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Component.class);
    }

    public <T> T getBean(Class<T> beanType) {
        throw new ExerciseNotCompletedException();
    }
}
