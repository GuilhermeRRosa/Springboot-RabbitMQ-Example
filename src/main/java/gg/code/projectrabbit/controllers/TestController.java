package gg.code.projectrabbit.controllers;

import gg.code.projectrabbit.sender.QueueSender;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private QueueSender queue;

    private final AmqpTemplate queueSender;

    public TestController(AmqpTemplate queueSender) {
        this.queueSender = queueSender;
    }

    @GetMapping
    public String send(){
        queue.send("testMessage");
        return "ok. done";
    }

    @GetMapping("/exchange")
    public String sendToExchange(){
        queueSender.convertAndSend("myexchange", "my-routing-key", "my message");
        return "ok. done";
    }

}
