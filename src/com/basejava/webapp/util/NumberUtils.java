package com.basejava.webapp.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberUtils {

        public static int minValue(int[] values) {
            return Arrays.stream(values)
                    .distinct()
                    .sorted()
                    .reduce(0, (r, i) -> r * 10 + i);
        }

        public static List<Integer> oddOrEven(List<Integer> integers) {
            int sum = integers.stream().mapToInt(Integer::intValue).sum();
            boolean isEven = sum % 2 == 0;
            return integers.stream()
                    .filter(i -> i % 2 != (isEven ? 0 : 1))
                    .collect(Collectors.toList());
        }
    }