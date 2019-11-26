package com.deepexi.service.impl;

import com.deepexi.domain.entity.Message;
import com.deepexi.mapper.MessageMapper;
import com.deepexi.service.ServiceForCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements ServiceForCRUD<Message> {
    @Autowired(required = false)
    MessageMapper messageMapper;

    @Override
    public int insert(Message message) {
        return messageMapper.insert(message);
    }

    @Override
    public boolean delete(Message message) {
        return messageMapper.deleteById(message.getMessage_id())==1;
    }

    @Override
    public boolean update(Message message) {
        return messageMapper.update(message)==1;
    }

    @Override
    public Message get(int id) {
        return messageMapper.getById(id);
    }

    @Override
    public List<Message> list() {
        return messageMapper.getAllMessage();
    }

    public List<Message> list(int rec_id) {
        return messageMapper.getAllMessageByRec_id(rec_id);
    }
}
