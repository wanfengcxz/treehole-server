package com.treehole.dao;

import com.treehole.entity.User;
import com.treehole.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author W.Q
 * @project treehole
 * @package com.treehole.dao
 * @date 2021.01.06
 */

@Mapper
public interface DataMapper {


    List<User> getUserByConditionIf(User user);

    List<Message> getMessageByConditionIf(Message message);

    // 根据手机号在User表中查询
    User selectUserByPhone(String phone);

    // 根据密码和手机号在User表中查询
    User selectUserByPhonePassword(String phone, String password);

    // 向User表中插入一条新的用户数据
    int insertOneUser(String user_name, String phone, String password, String face_url);

    int insertOneMessage(Message message);

    int deleteOneMessage(Message message);


//    // 用户登录
//    User login(String phone, String password);
//
    // 获取所有树洞消息
    List<Message> getAllMessage();
//
//    // 发布树洞
//    void publicMessage();
//
//    // 获取我的所有树洞
//    List<Message> getMyAllMessage(String password);
//
//    // 删除树洞
//    void deleteMessage(int id, int user_id);
//
//    // 点赞
//    void like(int id, int user_id);
//
//    // 是否存在当前用户
//    User isExist(String password);


}
