package com.kseensei.rabbitmqconsumer.controllers;

import com.kseensei.rabbitmqconsumer.models.ScheduledTask;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class AmqpReceiver {

    @Autowired
    private AmqpSender amqpSender;

    @RabbitListener(queues = "main-queue")
    public void sampleReceiver(ScheduledTask scheduledTask) throws Exception {
        try {  
            System.out.println(scheduledTask.toString());
            Thread.sleep(800);
            throw new Exception("test");
        } catch (Exception e) {
            //TODO: handle exception
            amqpSender.send("topic.retry.new", scheduledTask);
        }
        
    }
}