package com.kseensei.rabbitmqconsumer.models;

/**
 * ScheduledTask
 */
public class ScheduledTask {

    private String message;
    
    private Boolean received;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getReceived() {
        return received;
    }

    public void setReceived(Boolean received) {
        this.received = received;
    }

    @Override
    public String toString() {
        return "ScheduledTask [message=" + message + ", received=" + received + "]";
    }
}