package com.bobocode.reflection;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class DemoApp {

    public static void main(String[] args) {
        var person = new Person("John", "Gold", 43);
        var personJson = covertToJson(person);
        System.out.println(personJson); // should print {"firstName": "John", "lastName": "Gold", "age": 43}
    }

    /**
     * Accepts and arbitrary object and returns a JSON string representing all object's data.
     *
     * @param object
     * @return JSON string
     */
    @SneakyThrows
    private static String covertToJson(Object object) {
        StringBuilder builder = new StringBuilder();

        Field[] declaredFields = object.getClass().getDeclaredFields();
        builder.append("{").append("\n");
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            builder.append("\t")
                    .append(String.format("\"%s\"", field.getName()))
                    .append(" : ")
                    .append(getValue(object, field))
                    .append(i == declaredFields.length - 1 ? "\n": ",\n");
        }
        builder.append("}");
        return builder.toString();
    }

    private static String getValue(Object object, Field field) throws IllegalAccessException {
        if (field.getType().isPrimitive()) {
            return String.valueOf(field.get(object));
        }
        return ("\"" + field.get(object) + "\"");
    }


    static class Person {
        private String firstName;
        private String lastName;
        private int age;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
    }

}
