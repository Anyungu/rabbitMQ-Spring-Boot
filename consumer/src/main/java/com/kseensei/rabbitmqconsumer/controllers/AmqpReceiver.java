package com.kseensei.rabbitmqconsumer.controllers;

import com.kseensei.rabbitmqconsumer.models.ScheduledTask;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class AmqpReceiver {

    @RabbitListener(queues = "main-queue")
    public void sampleReceiver(ScheduledTask scheduledTask) {
        System.out.println(scheduledTask.toString());
    }
}