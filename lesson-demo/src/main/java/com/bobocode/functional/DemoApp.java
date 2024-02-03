package com.bobocode.functional;

import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;

public class DemoApp {

    //        Віталій Щербан - IntUnaryOperator
    public static void main(String[] args) {
//        IntUnaryOperator lambda = arg -> arg * 2;

//        int result = lambda.applyAsInt(10);
//        System.out.println(result);

       Supplier<String> process = () -> {
           try {
               System.out.println("Test1");
               if (true) throw new RuntimeException();
               return "Test2";
           } catch (Exception exception) {
               System.out.println(exception);
               throw exception;
           }
       };

        try {
            String s = process.get();
            System.out.println(s);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

}
