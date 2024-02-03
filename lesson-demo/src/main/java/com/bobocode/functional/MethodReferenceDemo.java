package com.bobocode.functional;

import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReferenceDemo {
    // Віталій Щербан - IntFunction

    public static void main(String[] args) {
        String hello = "Hello Bobocode!!!";

        IntFunction<Integer> increment = Math::incrementExact;
        System.out.println(increment.apply(0));

        IntFunction<String> substring = hello::substring;
        System.out.println(substring.apply(6));


        // not possible to do it on primitive
        Test test = new Test();
//        IntFunction<String> method1 = Test::repeat;

        ToIntFunction<String> tt = String::length;

        Consumer<Hello> stringConsumer = Hello::print;
//        stringConsumer.accept("hell");

    }

    private static class Test {
        public String repeat(int count) {
            return "Hello".repeat(count);
        }
    }

    private static class Hello {
        void print() {
            System.out.println("Hello");
        }
    }

}
