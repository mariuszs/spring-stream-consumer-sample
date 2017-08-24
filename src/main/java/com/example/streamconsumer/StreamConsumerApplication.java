package com.example.streamconsumer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableBinding(Sink.class)
public class StreamConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void loggerSink(Foo foo) {
        System.out.println("Received: " + foo);
    }

    @Bean
    public ParameterNamesModule parametersNameModule() {
        return new ParameterNamesModule(JsonCreator.Mode.PROPERTIES);
    }
}
