# ModernJava8

## Why Java8?

## Function 
```java
@FunctionalInterface //추상메서드를 하나만 갖는 인터페이스 -> 함수형 인터페이스
public interface Function<T, R> {
    //T -> R
    R apply(T t);
    //T -> T
    static <T> Function<T, T> identity() {
        return t -> t;
    }
}

```
## Consumer
```java
@FunctionalInterface
public interface Consumer<T> {
    //T -> void
    void accept(T t);
}

```
## Predicate
조건 확인
```java
@FunctionalInterface
public interface Predicate<T> {
    //T -> boolean
    boolean test(T t);
}
```
