package com.example.prometheus.controller;

import com.example.prometheus.metrics.PrometheusMetrics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class DemoController {

    @GetMapping("method1")
    @PrometheusMetrics
    public String method1() {
        return "method1";
    }

    @GetMapping("method2")
    @PrometheusMetrics
    public String method2() throws InterruptedException {
        TimeUnit.SECONDS.sleep( 2 );
        return "method2";
    }
}
