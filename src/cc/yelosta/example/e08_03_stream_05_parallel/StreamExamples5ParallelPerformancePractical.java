package cc.yelosta.example.e08_03_stream_05_parallel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExamples5ParallelPerformancePractical {

    public static void main(String[] args) {

    }
}

@AllArgsConstructor
@Data
class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}
