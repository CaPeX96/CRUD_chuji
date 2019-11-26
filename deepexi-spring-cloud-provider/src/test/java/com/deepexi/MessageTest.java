package com.deepexi;

import com.deepexi.domain.entity.Message;
import com.deepexi.mapper.MessageMapper;
import com.deepexi.mapper.UserMapper;
import io.codearte.jfairy.Fairy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MessageTest {
    protected Fairy fairy = Fairy.create();
    @Autowired(required = false)
    UserMapper userMapper;
    @Autowired(required = false)
    MessageMapper messageMapper;

    @Test
    public void deleteTest() {
        int i = messageMapper.deleteById(1);
        System.out.println(i);
        List<Message> messages = messageMapper.getAllMessage();
        for (Message message : messages) {
            System.out.println(message);
        }
    }

    @Test
    public void updateTest() {
        Integer id = 1;
        Message origin = messageMapper.getById(id);
        origin.setStatus(1);
        int update = messageMapper.update(origin);
        System.out.println(update);
    }

    @Test
    public void selectTest() {
        Message message = messageMapper.getById(1);
        System.out.println(message);
        List<Message> messages = messageMapper.getAllMessage();
        for (Message m : messages) {
            System.out.println(m);
        }
    }

    @Test
    public void insertTest() {
        Message message = new Message();
        message.setRec_id(2);
        message.setSend_id(1);
        message.setStatus(0);
        message.setContent("欢迎");
        message.setSend_date(System.currentTimeMillis());
        int i = messageMapper.insert(message);
        System.out.println(i);
    }
}
