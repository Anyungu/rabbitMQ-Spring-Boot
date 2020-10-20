package com.kseensei.rabbitmqproducer.services;

import java.util.UUID;

import com.kseensei.rabbitmqproducer.controllers.AmqpSender;
import com.kseensei.rabbitmqproducer.models.ScheduledTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * ScheduledTaskService
 */
@Service
public class ScheduledTaskService {

    @Autowired
    private AmqpSender amqpSender;

    @Scheduled(fixedDelay = 300)
    public void testSendingMessages() {
        UUID uuid = UUID.randomUUID();
        ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.setMessage(uuid.toString());
        scheduledTask.setReceived(true);
        amqpSender.send("topic.sample.new", scheduledTask);
    }

}