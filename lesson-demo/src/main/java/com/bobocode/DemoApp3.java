package com.bobocode;

import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DemoApp3 {

    public static void main(String[] args) {
        Comparator<Account> balanceComparator = thenComparing(
                comparing(Account::getBalance), Account::getLastName
        );
        List<Account> accounts = Accounts.generateAccountList(4);
        accounts.get(0).setBalance(BigDecimal.ONE);
        accounts.get(1).setBalance(BigDecimal.ONE);
        accounts.get(2).setBalance(BigDecimal.ONE);
        List<Account> sortedAccounts = accounts.stream()
                .sorted(balanceComparator)
                .collect(Collectors.toList());
        sortedAccounts.forEach(System.out::println);
    }

    /**
     * Returns a comparator of type T that is comparing values extracted using the provided mapper function.
     * <p>
     * E.g. imagine you need to compare accounts by their balance values.
     * <pre>{@code
     * Comparator<Account> balanceComparator = comparing(Account::getBalance);
     * }</pre>
     * <p>
     *
     * @param mapper a mapper function that allows to map an object to a comparable value
     * @return a comparator instance
     */
    // todo: implement method comparing according to javadoc
    static <T, R extends Comparable<R>> Comparator<T> comparing(Function<? super T, R> mapper) {
        return (a, b) -> {
            return mapper.apply(a).compareTo(mapper.apply(b));
        };
    }

    /**
     * Returns a comparator of type T that uses a provided comparator to compare objects, and only if they are equal
     * it's comparing values extracted using the provided mapper function.
     * <p>
     * E.g. suppose you want to compare accounts by balance, but in case two people have the same balance you want to
     * compare their first names:
     * <pre>{@code
     * Comparator<Account> accountComparator = thenComparing(balanceComparator, Account::getFirstName);
     * }</pre>
     * <p>
     *
     * @param comparator an initial comparator
     * @param mapper     a mapper function that is used to extract values when initial comparator returns zero
     * @return a comparator instance
     */
    // todo: implement method comparing according to javadoc
    static <T, R extends Comparable<R>> Comparator<T> thenComparing(Comparator<T> comparator, Function<? super T, R> mapper) {
        return (a, b) -> {
            int result = comparator.compare(a, b);
            if(result == 0) {
                return result;
            }
            return mapper.apply(a).compareTo(mapper.apply(b));
        };
    }

}
