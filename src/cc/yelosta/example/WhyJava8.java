package cc.yelosta.example;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class WhyJava8 {
    public static void main(String[] args) {

        // 1 : 2 : 3 : 4 : 5 : 6 : 7 : 8 : 9 : 10 와 같은 String 값을 만들고 싶다.

        // 방법 1 : String 사용 -> 생략

        // 방법 2 : StringBuilder 사용
        StringBuilder stringBuilder = new StringBuilder();
        UsingStringBuilder StringObj = new UsingStringBuilder();
        StringBuilder result2 = StringObj.build(stringBuilder);

        // 방법 3 : Steam 사용
        UsingStream streamObj = new UsingStream();
        String result3 = streamObj.getResult();

        System.out.println(result2);
        System.out.println(result3);


    }
}
class UsingStringBuilder {
    //숫자 리스트 생성
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    StringBuilder build(StringBuilder stringBuilder) {
        for (Integer number : numbers) {
            stringBuilder.append(number).append(" : ");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.delete(stringBuilder.length() - 3,
                    stringBuilder.length());
        }
        return stringBuilder;
    }

}
@Getter
class UsingStream {
    //숫자 리스트 생성
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    //Java 8의 스트림 이용
    final String result = numbers.stream()
            .map(String::valueOf)
            .collect(joining(" : "));


}
