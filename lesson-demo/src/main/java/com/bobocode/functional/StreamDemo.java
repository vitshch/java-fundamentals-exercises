package com.bobocode.functional;

import java.util.OptionalInt;

public class StreamDemo {

    public static void main(String[] args) {
        OptionalInt optionalInt = OptionalInt.of(getValue());

        int asInt = optionalInt.getAsInt();


    }

    private static int getValue() {
        return 0;
    }

}
