package com.example.prometheus.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yangyong
 */
@Slf4j
@Aspect
@Component
public class PrometheusMetricsAspect {

    public static final String DEFAULT_METRIC_NAME = "method_requests_count";
    public static final String DEFAULT_METRIC_TIMED_NAME = "method_requests_timed";
    public static final String DEFAULT_EXCEPTION_METRIC_NAME = "method_exception_count";

    public static final String EXCEPTION_TAG = "exception";


    private Map<String, Counter> counterMap = new ConcurrentHashMap<>();


    @Autowired
    private MeterRegistry meterRegistry;

    @PostConstruct
    private void init() {
        Counter counter = meterRegistry.counter( DEFAULT_EXCEPTION_METRIC_NAME, "method", EXCEPTION_TAG );
        counterMap.put( DEFAULT_EXCEPTION_METRIC_NAME, counter );
    }


    @Pointcut("@annotation(PrometheusMetrics)")
    public void pointcut() {
    }


    @Around("pointcut()&&@annotation(prometheusMetrics)")
    public Object invoke(ProceedingJoinPoint invocation, PrometheusMetrics prometheusMetrics) throws Throwable {
        String methodName = invocation.getSignature().getName();
        final String method = prometheusMetrics.methodName().isEmpty() ? methodName : prometheusMetrics.methodName();
        log.debug( "[PrometheusMetricsAspect] methodName : {}", method );
        Counter counter = getCounter( methodName, prometheusMetrics );
        counter.increment();
        Object result;
        Timer.Sample sample = Timer.start( meterRegistry );
        String exceptionClass = "none";
        try {
            result = invocation.proceed();
        } catch (Exception ex) {
            log.error( "[PrometheusMetricsAspect] Exception ", ex );
            exceptionClass = ex.getClass().getSimpleName();
            exceptionCounterIncrement();
            throw ex;
        } finally {
            sample.stop( Timer.builder( DEFAULT_METRIC_TIMED_NAME )
                    .description( prometheusMetrics.description().isEmpty() ? null : prometheusMetrics.description() )
                    .tags( prometheusMetrics.extraTags() )
                    .tags( EXCEPTION_TAG, exceptionClass )
                    .register( meterRegistry ) );
            exceptionCounterIncrement();
        }
        return result;
    }

    private Counter getCounter(String method, PrometheusMetrics prometheusMetrics) {
        Counter counter;
        if (counterMap.containsKey( method )) {
            counter = counterMap.get( method );
        } else {
            List<String> tags = new ArrayList( Arrays.asList( prometheusMetrics.extraTags() ) );
            tags.add( "method" );
            tags.add( method );
            counter = meterRegistry.counter( DEFAULT_METRIC_NAME, tags.toArray( new String[tags.size()] ) );
            counterMap.put( method, counter );
        }
        return counter;
    }

    private void exceptionCounterIncrement() {
        Counter counter = counterMap.get( DEFAULT_EXCEPTION_METRIC_NAME );
        counter.increment();
    }
}
