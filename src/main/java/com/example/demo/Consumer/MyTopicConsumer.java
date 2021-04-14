package com.example.demo.Consumer;

import com.example.demo.Model.UserDTO;
import com.example.demo.Repository.UsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyTopicConsumer {

    @Autowired
    private UsRepository usRepository;

    UserDTO userDTO = new UserDTO( 4L, "dsa");
    private final List<UserDTO> messages = new ArrayList<>();

    @KafkaListener(topics = "myTopic", groupId = "kafka-sandbox")
    public void listen(UserDTO message) {
        synchronized (messages) {
            messages.add(userDTO);
            usRepository.addToDB(messages.get(0));

        }

    }

    public List<UserDTO> getMessages() {
        return messages;
    }
}