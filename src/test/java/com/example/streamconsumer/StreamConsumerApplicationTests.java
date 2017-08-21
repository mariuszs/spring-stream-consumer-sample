package com.example.streamconsumer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamConsumerApplicationTests {

    @Autowired
    Sink sink;

    @Rule
    public OutputCapture capture = new OutputCapture();

    @Test
    public void contextLoads() throws InterruptedException {

        Message<String> message = MessageBuilder.withPayload("{\"value\":\"bar\"}").build();

        sink.input().send(message);

        assertThat(capture.toString())
                .contains("Received: Foo{value='bar'}");

    }
}
