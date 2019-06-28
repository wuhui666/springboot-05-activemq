package springboot05activemq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot05ActivemqApplicationTests {

    @Autowired
    JmsTemplate template;

    @Test
    public void testQueue() throws IOException {

        template.send("des01", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("do u freestyle?");
            }
        });

        System.out.println("send done,waiting....");
        System.in.read();
    }
    
    @Test
    public void testTopic() throws IOException {
        template.send("topic01", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("ay,ay,你看这个碗它又大又圆。。。");
            }
        });
        System.out.println("send done,waiting...");
        System.in.read();
    }

}
