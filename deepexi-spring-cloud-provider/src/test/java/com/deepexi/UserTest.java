package com.deepexi;

import com.deepexi.domain.entity.Message;
import com.deepexi.domain.entity.User;
import com.deepexi.domain.vo.UserVO;
import com.deepexi.mapper.MessageMapper;
import com.deepexi.mapper.UserMapper;
import com.deepexi.service.impl.MessageService;
import com.deepexi.service.impl.UserService;
import io.codearte.jfairy.Fairy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {
    protected Fairy fairy = Fairy.create();
    @Autowired(required = false)
    UserMapper userMapper;
    @Autowired(required = false)
    MessageMapper messageMapper;
    @Autowired
    UserService userService;
    @Autowired
    MessageService messageService;

    @Test
    public void userServiceTest(){//验证新建用户后欢迎信息的创建
        UserVO userVO = new UserVO();
        userVO.setAge(18);
        userVO.setName("小张");
        int id = userService.insert(userVO);
        if(id!=0){//创建成功
            List<Message> list = messageService.list(id);
            for (Message message : list) {
                if(message.getSend_id()==0){
                    System.out.println("系统对"+userService.get(message.getRec_id()).getName()+"发送了一条消息");
                }else {
                    System.out.println(userService.get(message.getSend_id()).getName()+"对"+userService.get(message.getRec_id()).getName()+"发送了一条消息");
                }
                System.out.println("内容为："+message.getContent());
                System.out.println("状态为："+(message.getStatus()==0?"未读":"已读"));
                System.out.println("发送时间为："+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(message.getSend_date())));
            }
        }
    }
    @Test
    public void deleteTest() {
        int i = userMapper.deleteById(1);
        System.out.println(i);
        List<User> users = userMapper.getAllUser();
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void updateTest() {
        Integer id = 2;
        User origin = userMapper.getById(id);
        User user = new User();
        user.setId(id);
        user.setAge(22);
        user.setName(origin.getName());
        user.setGmtCreate(origin.getGmtCreate());
        user.setGmtModified(System.currentTimeMillis());
        int u = userMapper.update(user);
        System.out.println(u);
    }

    @Test
    public void selectTest() {
        User user = userMapper.getById(1);
        System.out.println(user);
        List<User> users = userMapper.getAllUser();
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void insertTest() {
        User user = new User();
        user.setAge(23);
        user.setName("蔡培喜");
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(System.currentTimeMillis());
        int i = userMapper.insert(user);
        System.out.println(i);
    }
}
