package com.movit.study.listener;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by Administrator on 2017/2/3.
 */
@Component
public class QueueMessageListener implements MessageListener {
    public void onMessage(Message message) {
        //这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换，
        // 或者直接把onMessage方法的参数改成Message的子类TextMessage
        TextMessage textMsg = (TextMessage) message;
        System.out.println("queue 接收到一个纯文本消息。");
        try {
            System.out.println("消息内容是：" + textMsg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
