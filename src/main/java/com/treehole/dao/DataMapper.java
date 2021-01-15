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

    int insertOneUser(String user_name, String phone, String password, String face_url);

    int insertOneMessage(Message message);

    int deleteOneMessage(Message message);

    int updateTotalLike(int message_id);

}
