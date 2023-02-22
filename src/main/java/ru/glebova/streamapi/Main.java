package ru.glebova.streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static List<Integer> list = List.of(5, 8, 12, 31, 32, 40, 2, 54, 16, 7, 1);

    public static void main(String[] args) {

        findMinMax(Stream.of(5, 8, 12, 31, 32, 40, 2, 54, 16, 7, 1), Integer::compareTo,(min, max)->
        {
            System.out.printf("min: %d, max: %d \n", min, max);
        });

        findEvenNumbers(list);
    }

    public static <T> void findMinMax(Stream<T> stream, Comparator<T> comparator, BiConsumer<T, T> minMaxConsumer) {
        List<T> list = stream.sorted(comparator).collect(Collectors.toList());
        minMaxConsumer.accept(list.get(0), list.get(list.size()-1));
    }

    public static void findEvenNumbers(List<Integer> list) {
        List<Integer> result = list.stream().filter(e -> e % 2 == 0).toList();
        System.out.println(result);
    }
}
