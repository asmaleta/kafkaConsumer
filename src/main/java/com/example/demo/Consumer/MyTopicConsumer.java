package com.example.demo.Consumer;

import com.example.demo.DTO.User;
import com.example.demo.Repository.UsRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;

@Component
public class MyTopicConsumer {

    @Autowired
    private UsRepository usRepository;

    private final ArrayDeque<User> messages = new ArrayDeque<>();

    @KafkaListener(topics = "my-replicated-topic")
    public void listen(String message) {
        synchronized (messages) {
            Gson gson = new Gson();
            System.out.println(message);
            messages.add(gson.fromJson(message, User.class));
            usRepository.addToDB(messages.pop());

        }

    }

    public ArrayDeque<User> getMessages() {
        return messages;
    }
}