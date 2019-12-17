package com.example.prometheus;


import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PrometheusApplicationTests {

    void contextLoads() {
    }

    public static void main(String[] args) {
        //tag必须成对出现，也就是偶数个
        Counter counter = Counter.builder( "counter2" )
                .tag( "counter2", "counter2" )
                .description( "counter2" )
                .register( new SimpleMeterRegistry() );
        counter.increment();
        counter.increment( 2D );
        System.out.println( counter.count() );
        System.out.println( counter.measure() );
        //全局静态方法
        Metrics.addRegistry( new SimpleMeterRegistry() );
        counter = Metrics.counter( "counter", "counter", "counter" );
        counter.increment( 10086D );
        counter.increment( 10087D );
        System.out.println( counter.count() );
        System.out.println( counter.measure() );
    }
}
