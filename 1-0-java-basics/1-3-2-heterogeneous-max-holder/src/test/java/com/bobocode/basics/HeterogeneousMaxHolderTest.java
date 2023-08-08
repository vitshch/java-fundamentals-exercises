package com.bobocode.basics;

import com.bobocode.data.Accounts;
import com.bobocode.model.Account;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(OrderAnnotation.class)
class HeterogeneousMaxHolderTest {
    private HeterogeneousMaxHolder heterogeneousMaxHolder = new HeterogeneousMaxHolder();
    private HeterogeneousMaxHolder heterogeneousMaxHolderMock = Mockito.spy(HeterogeneousMaxHolder.class);

    @Test
    @Order(1)
    @DisplayName("A class does not declare type parameters")
    void classDoesNotDeclareTypeParameters() {
        var classTypeParams = HeterogeneousMaxHolder.class.getTypeParameters();

        assertThat(classTypeParams).isEmpty();
    }

    @Test
    @Order(2)
    @DisplayName("A class has one private field Map")
    void classHasOneField() {
        var fields = HeterogeneousMaxHolder.class.getDeclaredFields();

        assertThat(fields).hasSize(1);
        assertThat(fields[0].getType()).isEqualTo(Map.class);
    }

    @Test
    @Order(3)
    @DisplayName("A Map field declares type arguments")
    void mapFieldStoresTypeToObject() {
        var field = HeterogeneousMaxHolder.class.getDeclaredFields()[0];

        assertThat(field.getGenericType().getTypeName())
                .isEqualTo(Map.class.getTypeName() + "<%s, %s>", Class.class.getTypeName() + "<?>", Object.class.getTypeName());

    }

    @Test
    @Order(4)
    @DisplayName("put method exists")
    void putExists() {
        var putMethodExists = Arrays.stream(HeterogeneousMaxHolder.class.getDeclaredMethods())
                .anyMatch(m -> m.getName().equals("put"));

        assertTrue(putMethodExists);
    }

    @Test
    @Order(5)
    @DisplayName("put method declares one type parameter T")
    void putDeclaresOneTypeParam() {
        var putMethod = getPutMethod();

        var methodTypeParameters = putMethod.getTypeParameters();
        assertThat(methodTypeParameters).hasSize(1);

        var typeParam = putMethod.getTypeParameters()[0];
        assertThat(typeParam.getName()).isEqualTo("T");
    }

    @Test
    @Order(6)
    @DisplayName("put method accepts type-safe key")
    void putMethodAcceptsTypeSafeKeyParameter() {
        var putMethod = getPutMethod();

        var typeParam = (ParameterizedType) putMethod.getGenericParameterTypes()[0];
        var typeArgument = typeParam.getActualTypeArguments()[0];

        assertThat(typeParam.getRawType()).isEqualTo(Class.class);
        assertThat(typeArgument.getTypeName()).isEqualTo("T");
    }

    @Test
    @Order(7)
    @DisplayName("put method accepts comparable value")
    void putMethodAcceptsComparableValueParameter() {
        var putMethod = getPutMethod();

        var typeParam = putMethod.getTypeParameters()[0];
        var boundType = (ParameterizedType) typeParam.getBounds()[0];

        assertThat(boundType.getRawType()).isEqualTo(Comparable.class);
    }

    @Test
    @Order(8)
    @DisplayName("put method supports value that has comparable super class")
    void putMethodAcceptsValueParameterWithComparableSuperClass() {
        var putMethod = getPutMethod();

        var typeParam = putMethod.getTypeParameters()[0];
        var boundType = (ParameterizedType) typeParam.getBounds()[0];
        var typeArgument = boundType.getActualTypeArguments()[0].getTypeName();

        assertThat(boundType.getRawType()).isEqualTo(Comparable.class);
        assertThat(typeArgument).isEqualTo("? super T");
    }

    @Test
    @Order(9)
    @SneakyThrows
    @DisplayName("put stores provided value when current max is null")
    void putStoresValueWhenCurrentMaxIsNull() {
        callPut(String.class, "I am maximum");
        var storedMaxValue = getMaxHelper(String.class);

        assertThat(storedMaxValue).isEqualTo("I am maximum");
    }

    @Test
    @Order(10)
    @SneakyThrows
    @DisplayName("put returns null when current max is null")
    void putReturnsNullWhenCurrentMaxIsNull() {
        var result = callPut(String.class, "I am maximum");

        assertThat(result).isNull();
    }

    @Test
    @Order(11)
    @SneakyThrows
    @DisplayName("put stores provided value when current max is smaller than it")
    void putStoresValueWhenCurrentMaxIsSmaller() {
        givenMaxHolderWithData(Long.class, 123L);

        callPut(Long.class, 222L);
        var storedMaxValue = getMaxHelper(Long.class);

        assertThat(storedMaxValue).isEqualTo(222L);
    }

    @Test
    @Order(12)
    @SneakyThrows
    @DisplayName("put returns old max value when the provided value is greater than it")
    void putReturnsOldMaxValue() {
        givenMaxHolderWithData(Long.class, 123L);

        var returnedValue = callPut(Long.class, 222L);

        assertThat(returnedValue).isEqualTo(123L);
    }

    @Test
    @Order(13)
    @SneakyThrows
    @DisplayName("put ignores provided value when the current max is greater than it")
    void putIgnoresNewValueWhenCurrentMaxIsGreater() {
        givenMaxHolderWithData(Long.class, 123L);

        callPut(Long.class, 101L);
        var storedMaxValue = getMaxHelper(Long.class);

        assertThat(storedMaxValue).isEqualTo(123L);
    }

    @Test
    @Order(14)
    @SneakyThrows
    @DisplayName("put returns provided value when the current max is greater than it")
    void putReturnsProvidedValueWhenCurrentMaxIsGreater() {
        givenMaxHolderWithData(Long.class, 123L);

        var returnedValue = callPut(Long.class, 101L);

        assertThat(returnedValue).isEqualTo(101L);
    }

    @Test
    @Order(15)
    @SneakyThrows
    @DisplayName("put method is overloaded with additional Comparator parameter")
    void putIsOverloadedWithAdditionalComparatorParam() {
        HeterogeneousMaxHolder.class.getMethod("put", Class.class, Object.class, Comparator.class);
    }

    @Test
    @Order(16)
    @DisplayName("Overloaded put method declares one type parameter T")
    void overloadedPutDeclaresOneTypeParam() {
        var putMethod = getOverloadedPutMethod();

        var methodTypeParameters = putMethod.getTypeParameters();
        assertThat(methodTypeParameters).hasSize(1);

        var typeParam = putMethod.getTypeParameters()[0];
        assertThat(typeParam.getName()).isEqualTo("T");
    }

    @Test
    @Order(17)
    @DisplayName("Overloaded put method accepts type-safe key")
    void overloadedPutMethodAcceptsTypeSafeKeyParameter() {
        var putMethod = getOverloadedPutMethod();

        var typeParam = (ParameterizedType) putMethod.getGenericParameterTypes()[0];
        var typeArgument = typeParam.getActualTypeArguments()[0];

        assertThat(typeParam.getRawType()).isEqualTo(Class.class);
        assertThat(typeArgument.getTypeName()).isEqualTo("T");
    }

    @Test
    @Order(18)
    @DisplayName("Overloaded put method accepts value of arbitrary type T")
    void overloadedPutMethodAcceptsAnyValue() {
        var putMethod = getOverloadedPutMethod();

        var genericValueTypeParam = putMethod.getGenericParameterTypes()[1];
        var actualValueTypeParm = putMethod.getParameterTypes()[1];

        assertThat(genericValueTypeParam.getTypeName()).isEqualTo("T");
        assertThat(actualValueTypeParm).isEqualTo(Object.class);
    }

    @Test
    @Order(19)
    @SneakyThrows
    @DisplayName("Overloaded put method supports comparator of a super type")
    void overloadedPutAcceptsComparatorOfSuperTypes() {
        var putMethod = HeterogeneousMaxHolder.class.getMethod("put", Class.class, Object.class, Comparator.class);

        var comparatorParam = (ParameterizedType) putMethod.getGenericParameterTypes()[2];
        var comparatorTypeArgument = comparatorParam.getActualTypeArguments()[0];

        assertThat(comparatorTypeArgument.getTypeName()).isEqualTo("? super T");
    }

    @Test
    @Order(20)
    @SneakyThrows
    @DisplayName("Overloaded put stores provided value when current max is null")
    void overloadedPutStoresValueWhenCurrentMaxIsNull() {
        var account = Accounts.generateAccount();
        callPut(Account.class, account, Comparator.comparing(Account::getBalance));
        var storedMaxValue = getMaxHelper(Account.class);

        assertThat(storedMaxValue).isEqualTo(account);
    }

    @Test
    @Order(21)
    @SneakyThrows
    @DisplayName("Overloaded put returns null when current max is null")
    void overloadedPutReturnsNullWhenCurrentMaxIsNull() {
        var result = callPut(Account.class, Accounts.generateAccount(), Comparator.comparing(Account::getBalance));

        assertThat(result).isNull();
    }

    @Test
    @Order(22)
    @SneakyThrows
    @DisplayName("Overloaded put stores provided value when current max is smaller than it")
    void overloadedPutStoresValueWhenCurrentMaxIsSmaller() {
        var givenAccount = Accounts.generateAccount();
        givenMaxHolderWithData(Account.class, givenAccount);
        var biggerBalanceAccount = Accounts.generateAccount();
        biggerBalanceAccount.setBalance(givenAccount.getBalance().add(BigDecimal.TEN));

        callPut(Account.class, biggerBalanceAccount, Comparator.comparing(Account::getBalance));
        var storedMaxValue = getMaxHelper(Account.class);

        assertThat(storedMaxValue).isEqualTo(biggerBalanceAccount);
    }

    @Test
    @Order(23)
    @SneakyThrows
    @DisplayName("Overloaded put returns old max value when the provided value is greater than it")
    void overloadedPutReturnsOldMaxValue() {
        var givenAccount = Accounts.generateAccount();
        givenMaxHolderWithData(Account.class, givenAccount);
        var biggerBalanceAccount = Accounts.generateAccount();
        biggerBalanceAccount.setBalance(givenAccount.getBalance().add(BigDecimal.TEN));

        var returnedValue = callPut(Account.class, biggerBalanceAccount, Comparator.comparing(Account::getBalance));

        assertThat(returnedValue).isEqualTo(givenAccount);
    }

    @Test
    @Order(24)
    @SneakyThrows
    @DisplayName("Overloaded put ignores provided value when the current max is greater than it")
    void overloadedPutIgnoresNewValueWhenCurrentMaxIsGreater() {
        var givenAccount = Accounts.generateAccount();
        givenMaxHolderWithData(Account.class, givenAccount);
        var smallerBalanceAccount = Accounts.generateAccount();
        smallerBalanceAccount.setBalance(givenAccount.getBalance().subtract(BigDecimal.TEN));

        callPut(Account.class, smallerBalanceAccount, Comparator.comparing(Account::getBalance));
        var storedMaxValue = getMaxHelper(Account.class);

        assertThat(storedMaxValue).isEqualTo(givenAccount);
    }

    @Test
    @Order(25)
    @SneakyThrows
    @DisplayName("Overloaded put returns provided value when the current max is greater")
    void overloadedPutReturnsProvidedValueWhenCurrentMaxIsGreater() {
        var givenAccount = Accounts.generateAccount();
        givenMaxHolderWithData(Account.class, givenAccount);
        var smallerBalanceAccount = Accounts.generateAccount();
        smallerBalanceAccount.setBalance(givenAccount.getBalance().subtract(BigDecimal.TEN));

        var returnedValue = callPut(Account.class, smallerBalanceAccount, Comparator.comparing(Account::getBalance));

        assertThat(returnedValue).isEqualTo(smallerBalanceAccount);
    }

    @Test
    @Order(26)
    @DisplayName("getMax method exists")
    void getMaxExists() {
        var getMaxMethodExists = Arrays.stream(HeterogeneousMaxHolder.class.getDeclaredMethods())
                .anyMatch(m -> m.getName().equals("getMax"));

        assertThat(getMaxMethodExists).isTrue();
    }

    @Test
    @Order(27)
    @DisplayName("getMax declares one simple type param 'T'")
    void getMaxDeclaresOneTypeParam() {
        var getMaxMethod = getGetMaxMethod();

        var typeParams = getMaxMethod.getTypeParameters();

        assertThat(typeParams).hasSize(1);
        assertThat(typeParams[0].getTypeName()).isEqualTo("T");
    }

    @Test
    @Order(28)
    @DisplayName("getMax has one parameter")
    void getMaxHasOneParameter() {
        var getMaxMethod = getGetMaxMethod();

        var parameters = getMaxMethod.getParameters();

        assertThat(parameters).hasSize(1);
        assertThat(parameters[0].getType()).isEqualTo(Class.class);
    }

    @Test
    @Order(29)
    @DisplayName("getMax param specifies type arguments")
    void getMaxParamSpecifyTypeArguments() {
        var getMaxMethod = getGetMaxMethod();

        var parameter = getMaxMethod.getParameters()[0];

        assertThat(parameter.getParameterizedType().getTypeName()).isEqualTo(Class.class.getTypeName() + "<T>");
    }

    @Test
    @Order(30)
    @DisplayName("getMax returns value when it exists")
    void getMaxReturnsValueWhenItExists() {
        givenMaxHolderWithData(String.class, "I am maximum");

        var returnedValue = callGetMax(String.class);

        assertThat(returnedValue).isEqualTo("I am maximum");
    }

    @Test
    @Order(31)
    @DisplayName("getMax returns value when it exists")
    void getMaxReturnsNullWhenNoValueByGivenTypeExists() {
        var returnedValue = callGetMax(String.class);

        assertThat(returnedValue).isNull();
    }

    @Test
    @Order(32)
    @DisplayName("HeterogeneousMaxHolder keeps track of value one per each type")
    void maxHolderKeepsTrackOfMultipleValuesPerType() {
        callPut(String.class, "A");
        callPut(String.class, "C");
        callPut(String.class, "B");
        callPut(Long.class, 1L);
        callPut(Long.class, 5L);
        callPut(Long.class, 25L);

        var stringMax = callGetMax(String.class);
        var longMax = callGetMax(Long.class);

        assertThat(stringMax).isEqualTo("C");
        assertThat(longMax).isEqualTo(25L);
    }

    @SneakyThrows
    private <T> T callGetMax(Class<T> type) {
        var getMaxMethod = getGetMaxMethod();
        var result = getMaxMethod.invoke(heterogeneousMaxHolder, type);
        return type.cast(result);
    }

    private Method getGetMaxMethod() {
        return Arrays.stream(HeterogeneousMaxHolder.class.getDeclaredMethods())
                .filter(m -> m.getName().equals("getMax"))
                .findAny()
                .orElseThrow();
    }

    private Method getPutMethod() {
        return Arrays.stream(HeterogeneousMaxHolder.class.getDeclaredMethods())
                .filter(m -> m.getName().equals("put"))
                .filter(m -> m.getParameters().length <= 2)
                .findAny()
                .orElseThrow();
    }

    private Method getOverloadedPutMethod() {
        return Arrays.stream(HeterogeneousMaxHolder.class.getDeclaredMethods())
                .filter(m -> m.getName().equals("put"))
                .filter(m -> m.getParameters().length == 3)
                .findAny()
                .orElseThrow();
    }

    private void givenMaxHolderWithData(Class<?> type, Object value) {
        var map = getInternalMap();
        map.put(type, value);
        assertThat(getMaxHelper(type)).isEqualTo(value);
    }

    @SneakyThrows
    private <T> T callPut(Class<T> type, T value) {
        var putMethod = HeterogeneousMaxHolder.class.getMethod("put", Class.class, Comparable.class);

        return type.cast(putMethod.invoke(heterogeneousMaxHolder, type, value));
    }

    @SneakyThrows
    private <T> T callPut(Class<T> type, T value, Comparator<T> comparator) {
        var putMethod = HeterogeneousMaxHolder.class.getMethod("put", Class.class, Object.class, Comparator.class);

        return type.cast(putMethod.invoke(heterogeneousMaxHolder, type, value, comparator));
    }

    @SneakyThrows
    private <T> T getMaxHelper(Class<T> type) {
        Map<Class<?>, Object> map = getInternalMap();
        return type.cast(map.get(type));
    }

    @SneakyThrows
    private Map<Class<?>, Object> getInternalMap() {
        var mapField = HeterogeneousMaxHolder.class.getDeclaredFields()[0];
        mapField.setAccessible(true);
        @SuppressWarnings("unchecked")
        var map = (Map<Class<?>, Object>) mapField.get(heterogeneousMaxHolder);
        return map;
    }
}