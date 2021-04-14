package com.example.demo.Consumer;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Repository.UsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyTopicConsumer {

    @Autowired
    private UsRepository usRepository;

    UserDTO userDTO = new UserDTO( 4L, "dsa");
    private final ArrayDeque<UserDTO> messages = new ArrayDeque<>();

    @KafkaListener(topics = "myTopic", groupId = "kafka-sandbox")
    public void listen(UserDTO message) {
        synchronized (messages) {
            messages.add(message);
            usRepository.addToDB(messages.pop());

        }

    }

    public ArrayDeque<UserDTO> getMessages() {
        return messages;
    }
}