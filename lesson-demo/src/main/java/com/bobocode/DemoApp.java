package com.bobocode;

import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.util.Comparator;
import java.util.function.Function;

public class DemoApp {
    public static void main(String[] args) {

        Accounts.generateAccountList(10)
                .stream()
                .max(comparing(Account::getBalance))
                .ifPresent(System.out::println);

    }

    private static <T, R extends Comparable<R>> Comparator<T> comparing(Function<T, R> extractor) {
        return (a, b) -> extractor.apply(a).compareTo(extractor.apply(b));
    }
}
