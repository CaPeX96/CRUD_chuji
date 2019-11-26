package com.deepexi.service.impl;

import com.deepexi.domain.entity.Message;
import com.deepexi.domain.entity.User;
import com.deepexi.domain.vo.UserVO;
import com.deepexi.mapper.UserMapper;
import com.deepexi.service.ServiceForCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements ServiceForCRUD<UserVO> {
    @Autowired(required = false)
    UserMapper userMapper;
    @Autowired(required = false)
    MessageService messageService;

    @Override
    public int insert(UserVO userVO) {
        if (userMapper.countById(userVO.getId()) == 0) {//通过id判断表中无此用户
            User user = new User();
            user.setName(userVO.getName());
            user.setAge(userVO.getAge());
            user.setGmtModified(System.currentTimeMillis());
            user.setGmtCreate(System.currentTimeMillis());
            userMapper.insert(user);
            Message message = new Message();
            message.setContent("欢迎新用户" + user.getName() + "!");
            message.setSend_date(System.currentTimeMillis());
            int id = userMapper.getLastId();
            message.setRec_id(id);//主键自增长，刚创建id就是最后一个id
            messageService.insert(message);//插入一条欢迎新用户的信息
            return id;//返回创建的用户id
        }
        return 0;
    }

    @Override
    public boolean delete(UserVO userVO) {
        return userMapper.deleteById(userVO.getId()) == 1;
    }

    @Override
    public boolean update(UserVO userVO) {
        int id = userVO.getId();
        if (userMapper.countById(id) > 0) {
            User user = new User();
            user.setId(userVO.getId());
            user.setAge(userVO.getAge());
            user.setName(userVO.getName());
            user.setGmtModified(System.currentTimeMillis());//更新不对创建时间修改，故不作赋值
            return true;
        }
        return false;
    }

    @Override
    public UserVO get(int id) {
        User user = userMapper.getById(id);
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setAge(user.getAge());
        userVO.setName(user.getName());
        return userVO;
    }

    @Override
    public List<UserVO> list() {
        List<User> users = userMapper.getAllUser();
        List<UserVO> list = new ArrayList<>();
        for (User user : users) {
            UserVO userVO = new UserVO();
            userVO.setId(user.getId());
            userVO.setAge(user.getAge());
            userVO.setName(user.getName());
        }
        return list;
    }

}
