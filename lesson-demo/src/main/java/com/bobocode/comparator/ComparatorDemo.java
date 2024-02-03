package com.bobocode.comparator;

import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.util.Comparator;
import java.util.function.Function;

public class ComparatorDemo {

    public static void main(String[] args) {
        var theRichestPerson = Accounts.generateAccountList(10)
                .stream()
                .max(thenComparing(comparing(Account::getBalance), Account::getBirthday))
                .orElseThrow();

        System.out.println(theRichestPerson);
    }

    private static <T, R extends Comparable<? super R>> Comparator<T> comparing(Function<? super T, ? extends R> extractor) {
        return (o1, o2) -> extractor.apply(o1).compareTo(extractor.apply(o2));
    }

    private static <T, R extends Comparable<? super R>> Comparator<T> thenComparing(
            Comparator<? super T> comparator,
            Function<? super T, ? extends R> extractor
    ) {
        return (o1, o2) -> {
            int result = comparator.compare(o1, o2);
            return result != 0 ? result : extractor.apply(o1).compareTo(extractor.apply(o2));
        };
    }
}

