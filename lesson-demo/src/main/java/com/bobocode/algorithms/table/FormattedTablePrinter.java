package com.bobocode.algorithms.table;

import org.apache.commons.lang3.StringUtils;

public class FormattedTablePrinter {

    private static final int COLUMNS = 5;
    private static final int TAB = 4;

    public static void main(String[] args) {
        String[] input = new String[]{
                "1", "2", "3", "x", "5",
                "6", "a", "porosiatko", "c", "10",
                "11", "12", "13", "14", "15",
                "16"
        };
        printFormattedTable(input);
    }

    private static void printFormattedTable(String[] input) {
        int num = input.length / COLUMNS;
        int[] columnWidth = calculateColumnWidth(input);

        for (int i = 0; i < input.length; i++) {
            if (i % COLUMNS == 0) {
                System.out.println();
            }
            System.out.print(input[i] + calculateRightMargin(input, columnWidth, i));
        }
        System.out.println();
    }

    private static int[] calculateColumnWidth(String[] input) {
        int[] columnWidth = new int[COLUMNS];

        for (int i = 0; i < input.length; i++) {
            int column = i % COLUMNS;
            int currentWidth = input[i].length();
            if (currentWidth > columnWidth[column]) {
                columnWidth[column] = currentWidth;
            }
        }

        return columnWidth;
    }

    private static String calculateRightMargin(String[] input, int[] columnWidth, int i) {
        int margin = columnWidth[i % COLUMNS] - input[i].length() + TAB;
        return StringUtils.repeat(" ", margin);
    }

}
