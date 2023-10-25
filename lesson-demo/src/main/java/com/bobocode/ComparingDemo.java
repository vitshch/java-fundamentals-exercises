package com.bobocode;

//ONLINE TRAINING 14 | TASK 0
//        👉  Implement a custom method comparing
//
//        Checkout the following code snippet
//        var theRichestPerson = Accounts.generateAccountList(10)
//        .stream()
//        .max(comparing(Account::getBalance))
//        .orElseThrow();
//
//        Implement a custom method comparing
//        Make sure it works
//        Post the screenshots of your code in the Thread  👇


import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ComparingDemo {

    public static void main(String[] args) {
        List<Account> accounts = Accounts.generateAccountList(10);
        accounts.forEach(System.out::println);

        var theRichestPerson = accounts.stream()
                .max(comparing(Account::getBalance))
                .orElseThrow();

        System.out.println();
        System.out.println(theRichestPerson);
    }

    private static <T, R extends Comparable<? super R>> Comparator<? super T> comparing(Function<? super T, ? extends R> function) {
        return (a, b) -> function.apply(a).compareTo(function.apply(b));
    }

}
