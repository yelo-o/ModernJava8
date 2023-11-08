package cc.yelosta.example.e08_01_stream_prelude;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StreamPrelude {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        final int minInt = Math.abs(Integer.MIN_VALUE);
        System.out.println("minINt : " + minInt);

        //Identity Function Test
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("mapOld(numbers, i -> i * 2)");
        System.out.println(
                mapOld(numbers, i -> i * 2)
        );
        System.out.println("mapOld(numbers, null)");
        System.out.println(
                map(numbers, null)
        );

        System.out.println("");
        System.out.println("map(numbers, i -> i * 2)\n" +
                map(numbers, i -> i * 2)
        );
        System.out.println("map(numbers, Function.identity())\n" +
                map(numbers, Function.identity())
        );

    }

    private static <T,R> List<R> map(final List<T> list, final Function<T, R> mapper) {
        final Function<T,R> function;
        if (mapper != null) {
            function = mapper;
        } else {
            function = t -> (R) t;
        }
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    private static <T,R> List<R> mapOld(List<T> list, Function<T,R> mapper) {
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }

}
