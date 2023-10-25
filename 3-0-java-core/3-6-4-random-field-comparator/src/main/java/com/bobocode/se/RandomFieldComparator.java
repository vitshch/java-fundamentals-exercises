package com.bobocode.se;

import com.bobocode.util.ExerciseNotCompletedException;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/**
 * A generic comparator that is comparing a random field of the given class. The field is either primitive or
 * {@link Comparable}. It is chosen during comparator instance creation and is used for all comparisons.
 * <p>
 * If no field is available to compare, the constructor throws {@link IllegalArgumentException}
 *
 * @param <T> the type of the objects that may be compared by this comparator
 *<p><p>
 *  <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com/learn">visit our website</a></strong>
 *  <p>
 *
 * @author Stanislav Zabramnyi
 */
public class RandomFieldComparator<T> implements Comparator<T> {

    private Class<T> targetType;
    private Field field;

    public RandomFieldComparator(Class<T> targetType) {
        if (targetType == null) {
            throw new IllegalArgumentException();
        }
        if (targetType.getFields().length == 0) {
            throw new NullPointerException();
        }
        var fields = Stream.of(targetType.getFields())
                .filter(f -> f.getType().isPrimitive() || f.getType().isAssignableFrom(Comparable.class))
                .toList();
        var length = fields.size();
        if (length == 0) {
            throw new IllegalArgumentException();
        }
        var index = ThreadLocalRandom.current().nextInt(length);
        field = fields.get(index);
    }

    /**
     * Compares two objects of the class T by the value of the field that was randomly chosen. It allows null values
     * for the fields, and it treats null value greater than a non-null value.
     *
     * @param o1
     * @param o2
     * @return positive int in case of first parameter {@param o1} is greater than second one {@param o2},
     *         zero if objects are equals,
     *         negative int in case of first parameter {@param o1} is less than second one {@param o2}.
     */
    @Override
    public int compare(T o1, T o2) {
        throw new ExerciseNotCompletedException(); // todo: implement this method;
    }

    /**
     * Returns the name of the randomly-chosen comparing field.
     */
    public String getComparingFieldName() {
        throw new ExerciseNotCompletedException(); // todo: implement this method;
    }

    /**
     * Returns a statement "Random field comparator of class '%s' is comparing '%s'" where the first param is the name
     * of the type T, and the second parameter is the comparing field name.
     *
     * @return a predefined statement
     */
    @Override
    public String toString() {
        throw new ExerciseNotCompletedException(); // todo: implement this method;
    }
}
