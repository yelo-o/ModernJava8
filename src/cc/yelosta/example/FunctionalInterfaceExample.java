package cc.yelosta.example;

import java.util.function.Function;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {

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
    }
}
