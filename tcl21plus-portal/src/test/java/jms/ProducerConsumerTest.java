package jms;

import com.movit.study.jms.MessageSender;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

/**
 * Created by Administrator on 2017/2/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-jms-test.xml")
public class ProducerConsumerTest {
    @Autowired
    private MessageSender messageSender;

    @Autowired
    @Qualifier("queueDestination")
    private Destination queueDestination;

    @Autowired
    @Qualifier("topicDestination")
    private Destination topicDestination;

    @Test
    public void testSendQueue() {
        for (int i = 0; i < 2; i++) {
            messageSender.sendMessage(queueDestination, "queue,你好，生产者！这是消息：" + (i + 1));
        }
    }

    @Test
    public void testSendTopic() {
        messageSender.sendMessage(topicDestination, "topic,你好，生产者!");

    }
}
