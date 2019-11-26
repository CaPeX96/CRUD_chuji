package com.deepexi.mapper;

import com.deepexi.domain.entity.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("select * from message")
    List<Message> getAllMessage();//查所有
    @Select("select * from message where message_id = #{message_id}")
    Message getById(Integer message_id);//查
    @Insert("insert into message(send_id,rec_id,content,status,send_date) values(#{send_id},#{rec_id},#{content},#{status},#{send_date})")
    int insert(Message message);//增
    @Delete("delete from message where message_id = #{message_id}")
    int deleteById(Integer message_id);//删
    @Update("update message set send_id = #{send_id},rec_id=#{rec_id},content=#{content},status=#{status},send_date=#{send_date} where message_id = #{message_id}")
    int update(Message message);//改
    @Select("select * from message where rec_id = #{rec_id}")
    List<Message> getAllMessageByRec_id(Integer rec_id);//查某用户的所有消息
}
