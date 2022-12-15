package com.bobocode.lambda;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.function.LongSupplier;

public class MethodReferenceDemo {

    public static void main(String[] args) {
        CurrentDateTime currentDateTime = new CurrentDateTime();

        LongSupplier staticRef = CurrentDateTime::minLong;
        LongSupplier objectRef = currentDateTime::getCurrentTime;
    }

    static class CurrentDateTime {

        static long minLong() {
            return Long.MIN_VALUE;
        }

        long getCurrentTime() {
            return LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        }
    }

}
