package com.example

import io.opentelemetry.api.GlobalOpenTelemetry
import io.opentelemetry.api.OpenTelemetry
import io.opentelemetry.api.metrics.LongCounter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MetricsConfig {
    @Bean
    fun openTelemetry(): OpenTelemetry = GlobalOpenTelemetry.get()

    @Bean
    fun personGetCounter(openTelemetry: OpenTelemetry): LongCounter  =
        openTelemetry.getMeter("person-meter")
            .counterBuilder("person_get_count")
            .setUnit("total")
            .build()
}