package com.bobocode;

public class FormattedTablePrinter {

    public static void main(String[] args) {
        String[] input = new String[]{"1", "2", "3", "x", "5", "6", "a", "porosiatko", "c", "10", "11", "12", "13", "14", "15", "16"};
        printFormatted(input);
    }

    private static void printFormatted(String[] input) {
        int columns[] = new int[5];
        for (int i = 0; i < input.length; i++) {
            int index = i % 5;
            int length = input[i].length();
            if (length > columns[index]) {
                columns[index] = length;
            }
        }

        for (int i = 0; i < input.length; i++) {
            int columnSize = columns[i % 5] - input[i].length() + 4;
            if (i % 5 == 0) {
                System.out.print("\n");
            }
            System.out.printf("%s%s", input[i], " ".repeat(columnSize));
        }
    }

}
