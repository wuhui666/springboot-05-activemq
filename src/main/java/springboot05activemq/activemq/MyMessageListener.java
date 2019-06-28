package springboot05activemq.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author: wuhui
 * @time: 2019/6/27 14:58
 * @desc:
 */
@Component
public class MyMessageListener implements MessageListener {
    @Override
    @JmsListener(destination = "des01")
    public void onMessage(Message message) {
        try {
            System.out.println("get msg with text:"
                    +((TextMessage)message).getText());

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    @JmsListener(destination = "topic01")
    public void onMessageTopic1(Message message) {
        try {
            System.out.println("consumer01 get msg with text from topic:"
                    +((TextMessage)message).getText());

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    @JmsListener(destination = "topic01")
    public void onMessageTopic2(Message message) {
        try {
            System.out.println("consumer02 get msg with text from topic:"
                    +((TextMessage)message).getText());

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
