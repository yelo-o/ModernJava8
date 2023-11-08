package cc.yelosta.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamExamples3 {
    public static void main(String[] args) {

        System.out.println("collect(toList()) : " +
            Stream.of(1, 3, 3, 5, 5)
                    .filter(i -> i > 2)
                    .map(i -> i * 2)
                    .map(i -> "#" + i)
                    .collect(toList())
        );

        System.out.println("collect(toSet()) : " +
                Stream.of(1, 3, 3, 3, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(toSet())
        );
        System.out.println("collect(joining()) : " +
                Stream.of(1, 3, 3, 3, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(joining())
        );
        System.out.println("collect(joining(\", \")) : " +
                Stream.of(1, 3, 3, 3, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(joining(", "))
        );
        System.out.println("collect(joining(\", \", \"[\", \"]\")) : " +
                Stream.of(1, 3, 3, 3, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(joining(", ", "[", "]")) //[#6, #6, #6, #10]
        );
        System.out.println("distinct().collect(joining(\", \", \"[\", \"]\")) : " +
                Stream.of(1, 3, 3, 3, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .distinct() //set을 사용하지 않고도 값이 중복되지 않도록 함
                        .collect(joining(", ", "[", "]")) //[#6, #10]
        );
        System.out.println("distinct().collect(toList()) : " +
                Stream.of(1, 3, 3, 3, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .distinct() //set을 사용하지 않고도 값이 중복되지 않도록 함
                        .collect(toList())
        );

        /**
         * int와 Integer
         */
        final Integer integer3 = 3;
        System.out.println(
                Stream.of(1, 2, 3, 4, 5)
                        .filter(i -> i == integer3)
                        .findFirst()
        );
        final Integer integer127 = 127;
        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 127)
                        .filter(i -> i == integer127)
                        .findFirst()
        );
        final Integer integer128 = 128;
        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 128)
                        .filter(i -> i == integer128)
                        .findFirst()
        );
        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 128)
                        .filter(i -> i.equals(integer128))
                        .findFirst()
        );
        //부등호는 primitive로 비교하기 때문에 자동으로 auto-unboxing 이 일어남
        System.out.println( "filter(i -> i > integer3).count() : " +
                Stream.of(1, 2, 3, 4, 5)
                        .filter(i -> i > integer3)
                        .count()
        );

        //forEach() <- Internal iterator (내부 반복자)
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("for (Integer number : numbers) : ");
        for (Integer number : numbers) {
            System.out.print("number = " + number + " ");
        }
        System.out.println("\nforEach(i -> System.out.println(i)) : ");
        //for (Integer number : numbers) <- External Iterator (외부 반복자)
        Stream.of(1, 2, 3, 4, 5)
                .forEach(i -> System.out.print(i + " "));

    }
}
