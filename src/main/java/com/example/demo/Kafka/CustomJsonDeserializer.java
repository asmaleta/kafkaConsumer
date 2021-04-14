package com.example.demo.Kafka;

import org.springframework.kafka.support.serializer.JsonDeserializer;

public class CustomJsonDeserializer extends JsonDeserializer {
    public CustomJsonDeserializer() {
        super();
        this.addTrustedPackages("*");
    }
}