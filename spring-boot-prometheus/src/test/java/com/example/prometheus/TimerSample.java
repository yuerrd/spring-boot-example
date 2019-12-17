package com.example.prometheus;


import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TimerSample {
    public static void main(String[] args) throws Exception {
        Timer timer = Timer.builder( "timer" )
                .publishPercentiles( 0.5, 0.95 ) // median and 95th percentile
                .publishPercentileHistogram()
                .tag( "timer", "timer" )
                .description( "timer" )
                .register( new SimpleMeterRegistry() );
        timer.record( () -> {
            try {
                TimeUnit.SECONDS.sleep( 2 );
            } catch (InterruptedException e) {
                //ignore
            }
        } );
        System.out.println( timer.count() );
        System.out.println( timer.measure() );
        System.out.println( timer.totalTime( TimeUnit.SECONDS ) );
        System.out.println( timer.mean( TimeUnit.SECONDS ) );
        System.out.println( timer.max( TimeUnit.SECONDS ) );
    }
}
