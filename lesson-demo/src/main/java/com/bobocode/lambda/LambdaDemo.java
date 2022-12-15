package com.bobocode.lambda;

import java.util.function.IntToLongFunction;

public class LambdaDemo {

    public static void main(String[] args) {
        IntToLongFunction function = intValue -> (long) intValue;

        IntToLongFunction functionalBlock = intValue -> {
            return (long) intValue;
        };
    }
}
