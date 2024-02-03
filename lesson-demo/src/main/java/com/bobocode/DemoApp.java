package com.bobocode;

import lombok.SneakyThrows;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;

public class DemoApp {
    public static void main(String[] args) {
        Person person = new Person("John", "Gold", 43, new int[]{1, 2, 3, 4});
        var personJson = covertToJson(person);
        System.out.println(personJson); // should print {"firstName": "John", "lastName": "Gold", "age": 43}
    }

    @SneakyThrows
    private static String covertToJson(Object object) {
        StringBuilder builder = new StringBuilder();
        Field[] declaredFields = object.getClass().getDeclaredFields();
        builder.append("{");
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
//            field.setAccessible(true);
            builder.append("\n")
                    .append("\t\"%s\"".formatted(field.getName()))
                    .append(": ")
                    .append(getFieldValue(field, object));
            if (i < declaredFields.length - 1) {
                builder.append(",");
            }
        }
        builder.append("\n}");
        return builder.toString();
    }

    @SneakyThrows
    private static String getFieldValue(Field field, Object object) {
        field.setAccessible(true);
        if (field.getType().isPrimitive()) {
            return String.valueOf(field.get(object));
        } else if (field.getType().isArray()) {
            return "";
        } else {
            return "\"%s\"".formatted(field.get(object));
        }
    }

    static class Person {
        private String firstName;
        private String lastName;
        private int age;
        private int[] numbers;

        public Person(String firstName, String lastName, int age, int[] numbers) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.numbers = numbers;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int[] getNumbers() {
            return numbers;
        }
    }
}
