package cc.yelosta.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExample {
    private void run4FunctionalInterfaces() {

        /**
         * Function 활용
         */
        //1. Function 함수를 이용한 함수형 프로그래밍 시작
//        Function<String, Integer> toInt = new Function<String, Integer>() {
//            @Override
//            public Integer apply(final String value) {
//                return Integer.parseInt(value);
//            }
//        };

        //2. 코드 간소화
        final Function<String, Integer> toInt = value -> Integer.parseInt(value);

        final Integer number = toInt.apply("100");
        System.out.println(number);

        //3. Identity 사용
//        final Function<Integer, Integer> identity = Function.identity();
        //람다 expression 사용
        final Function<Integer, Integer> identity = t -> t;

        System.out.println(identity.apply(999));

        /**
         * Consumer 활용
         */
        //1. 함수혈 프로그래밍 boilerplate 제작
//        final Consumer<String> print = new Consumer<String>() {
//            @Override
//            public void accept(final String value) {
//                System.out.println(value);
//            }
//        };

        //2. 람다식으로 변경
        final Consumer<String> print = value -> System.out.println(value);
        final Consumer<String> greetings = value -> System.out.println("Hello " + value);
        print.accept("Hi");
        greetings.accept("World");
        greetings.accept("Tom");

        /**
         * Predicate 활용
         */
        Predicate<Integer> isPositive = i -> i > 0;

        System.out.println(isPositive.test(1));
        System.out.println(isPositive.test(0));
        System.out.println(isPositive.test(-1));

        //Predicate 예제
        List<Integer> numbers = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);

        //양의 정수 구하기
        List<Integer> positiveNumbers = new ArrayList<>();
        for (Integer num : numbers) {
            if (isPositive.test(num)) {
                positiveNumbers.add(num);
            }
        }
        System.out.println("positive integers : " + positiveNumbers);

        //3보다 작은 정수 구하기
        Predicate<Integer> lessThan3 = i -> i < 3;
        List<Integer> numberLessThan3 = new ArrayList<>();
        for (Integer num : numbers) {
            if (lessThan3.test(num)) {
                numberLessThan3.add(num);
            }
        }
        System.out.println("less than 3 integers : " + numberLessThan3);

        //static 메소드 사용해서 구하기

        System.out.println("positive integers with static method: " + filter(numbers,isPositive));
        System.out.println("less than 3 integers static method : " + filter(numbers, lessThan3));

        /**
         * Supplier 활용
         */
        final Supplier<String> helloSupplier = () -> "Hello";
        System.out.println(helloSupplier.get() + "world");

//        printIfValidIndex(0, "Kevin");
//        printIfValidIndex(1, "Kevin");
//        printIfValidIndex(-1, "Kevin");

        long start = System.currentTimeMillis();
        printIfValidIndex(0, () -> getVeryExpensiveValue());
        printIfValidIndex(-1, () -> getVeryExpensiveValue());
        printIfValidIndex(-2, () -> getVeryExpensiveValue());
        System.out.println("It took " + (( System.currentTimeMillis() - start )) / 1000 + " seconds.");
    }

    private static String getVeryExpensiveValue() {
        //가정 : 굉장히 많은 computing power 를 소모
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Kevin";
    }
//    private static void printIfValidIndex(int number, String value) {
    private static void printIfValidIndex(int number, Supplier<String> valueSupplier) {
        if (number >= 0) {
            System.out.println("The value is " + valueSupplier.get() + ".");
        } else {
            System.out.println("Invalid");
        }
    }
    private static <T> List<T> filter(List<T> list, Predicate<T> filter) {
        List<T> result = new ArrayList<>();
        for (T input : list) {
            if (filter.test(input)) {
                result.add(input);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        println(1L, "Kevin", "test@email.com",
                (id, name, email) -> "User info : ID=" + id + ", name=" + name + ", email=" + email);
    }
    private static <T1, T2, T3> void println(T1 t1, T2 t2, T3 t3, Function3<T1, T2, T3, String> function) {
        System.out.println(function.apply(t1, t2, t3));
    }
}
@FunctionalInterface
interface Function3<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);
}
