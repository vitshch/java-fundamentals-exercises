package com.bobocode;

import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ComparingDemo2 {

    public static void main(String[] args) {
        var theRichestPerson = Accounts.generateAccountList(10)
                .stream()
                .max(comparing(Account::getBalance))
                .orElseThrow();
        System.out.println(theRichestPerson);

        System.out.println("-------------------");

        List<Account> accounts = Accounts.generateAccountList(5);
        accounts.stream()
                .sorted(thenComparing(comparing(Account::getBalance), Account::getBirthday))
                .forEach(System.out::println);

        System.out.println("-------------------");

        accounts.stream()
                .sorted(Comparator.comparing(Account::getBalance).thenComparing(Account::getBirthday))
                .forEach(System.out::println);

    }
    //??
    private static <T, R extends Comparable<? super R>> Comparator<T> comparing(Function<? super T, ? extends R> extractor) {
        return (a, b) -> extractor.apply(a).compareTo(extractor.apply(b));
    }

    private static <T, R extends Comparable<? super R>> Comparator<T> thenComparing(Comparator<T> comparator, Function<T, R> extractor) {
        return (a, b) -> {
            int result = comparator.compare(a, b);
            if (result == 0) {
                return extractor.apply(a).compareTo(extractor.apply(b));
            }
            return result;
        };
    }
}
