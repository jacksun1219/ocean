package com.jacksun1219.ocean.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GridUtil {

    /**
     * @param string, e.g.
        11110
        11010
        11000
        00000
     * @return 4*5 2d int array
     */
    public static List<List<Integer>> getGrid(String string) {
        List<List<Integer>> res = new ArrayList<>();
        Stream.of(string.split("\\r?\\n"))
                .forEach(s -> {
                    res.add(IntStream.range(0, s.length())
                            .mapToObj(i -> s.charAt(i) - '0').collect(Collectors.toList()));
        });
        return res;
    }

    public static int[][] getArray(List<List<Integer>> input) {
        try {
            int rows = input.size();
            int cols = input.get(0).size();
            int[][] res = new int[rows][cols];
            IntStream.range(0, rows)
                    .forEach(i -> {
                        IntStream.range(0, cols)
                                .forEach(j -> {
                                    res[i][j] = input.get(i).get(j);
                                });
                    });
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
