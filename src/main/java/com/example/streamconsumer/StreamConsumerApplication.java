package com.example.streamconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

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

}
