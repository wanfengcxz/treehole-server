package com.treehole.service.Impl;

import com.treehole.dao.DataMapper;
import com.treehole.entity.Message;
import com.treehole.entity.User;
import com.treehole.res.Result;
import com.treehole.res.ResultUtil;
import com.treehole.service.TreeholeService;
import com.treehole.util.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import java.util.List;

@Service
public class TreeholeServiceImpl implements TreeholeService {

    @Autowired
    DataMapper dataMapper;

    @Override
    public Result register(String user_name, String phone, String password, String face_url) {
        // 由于数据库设置了约束：手机号字段唯一，则查询时最多获得一条数据

        // 首先在User表中查询该手机号有没有被注册过
        User user = new User();
        user.setPhone(phone);
        List<User> user_list_res = dataMapper.getUserByConditionIf(user);
        // 如果查询出记录，则该手机号已被注册过
        if (user_list_res.size() != 0){
            return ResultUtil.phoneRepeatition();
        }
        // 如果查询不出记录，则该手机号未被注册
        else {
            // 准许注册
            // 向User表中插入一条新的用户数据
            int res = dataMapper.insertOneUser(user_name,phone,password,face_url);
            // 插入成功
            if (res == 1)
                return ResultUtil.success();
                // 未知错误
            else {
                return ResultUtil.unkonwnError();
            }
        }
    }

    @Override
    public Result login(String phone, String password) {
        User find_condition = new User();
        find_condition.setPhone(phone);
        List<User> user_list_res = dataMapper.getUserByConditionIf(find_condition);
        // 如果查询为空，则该手机号没有注册帐号
        if (user_list_res.size() == 0){
            return ResultUtil.userNotExist();
        }
        // 当前手机号注册有帐号
        else {
            // 根据手机号和密码在数据库中查询
            find_condition.setPassword(password);
            user_list_res = dataMapper.getUserByConditionIf(find_condition);
            // 如果查询结果为空，则密码错误
            if (user_list_res.size() == 0){
                return ResultUtil.passwordError();
            }
            // 已注册，可以登录
            else {
                user_list_res.get(0).setPassword(AESUtil.encode(String.valueOf(user_list_res.get(0).getId())));
                return ResultUtil.success(user_list_res.get(0));
            }
        }
    }

    @Override
    public Result publicMessage(String user_id, String encrypt_code, String content, String send_timestamp) {
        try {
            // 验证用户
            String id_decrypt = AESUtil.decode(encrypt_code);


            // 合法
            if (user_id.equals(id_decrypt)){

                // 根据user_id获取user_name和face_url
                int int_id = Integer.valueOf(user_id).intValue();
                User user = new User();
                user.setId(int_id);
                List<User> userList = dataMapper.getUserByConditionIf(user);
//            System.out.println(userList.get(0).getUser_name());

                // 转换时间戳
                int send_timestamp_int = Integer.valueOf(send_timestamp).intValue();

                // 构造message数据
                Message message = new Message(0,int_id, userList.get(0).getUser_name(),
                        userList.get(0).getFace_url(),content,0,send_timestamp_int);

                // 插入树洞消息(Message)
                dataMapper.insertOneMessage(message);

                return ResultUtil.success();
            }
            // 不合法
            else {
                // 非法访问
                return ResultUtil.illegalAccess();
            }
        }

        catch (BadPaddingException e){
            // 解密错误
            return ResultUtil.illegalAccess();
        }
    }

    @Override
    public Result getMyAllMessage(String user_id, String encrypt_code) {
        try {
            // 验证用户
            String id_decrypt = AESUtil.decode(encrypt_code);
            // 合法
            if (user_id.equals(id_decrypt)) {

                // user_id
                int int_id = Integer.valueOf(user_id).intValue();

                // 构造查找条件
                Message message = new Message();
                message.setUser_id(int_id);
//                System.out.println(int_id);
//                System.out.println(message.toString());

                List<Message> messageList = dataMapper.getMessageByConditionIf(message);
//                System.out.println(messageList);

                return ResultUtil.success(messageList);
            }
            // 不合法
            else {
                return ResultUtil.illegalAccess();
            }
        }
        catch (BadPaddingException e){
            // 解密失败
            return ResultUtil.illegalAccess();
        }
    }

    @Override
    public Result deleteMessage(String user_id, String encrypt_code, String message_id) {
        try {
            // 验证用户
            String id_decrypt = AESUtil.decode(encrypt_code);
            // 合法
            if (user_id.equals(id_decrypt)) {

                // message_id
                int int_id = Integer.valueOf(message_id).intValue();

                // 构造删除条件
                Message message = new Message();
                message.setId(int_id);
                System.out.println(int_id);
                System.out.println(message.toString());

                int res_code = dataMapper.deleteOneMessage(message);
                System.out.println(res_code);

                // 删除成功
                if (res_code == 1){
                    return ResultUtil.success();
                }
                // 未知错误
                else {
                    return ResultUtil.unkonwnError();
                }
            }
            // 不合法
            else {
                return ResultUtil.illegalAccess();
            }
        }
        catch (BadPaddingException e){
            // 解密失败
            return ResultUtil.illegalAccess();
        }
    }

    @Override
    public Result getAllMessage(String user_id, String encrypt_code) {
        try {
            // 验证用户
            String id_decrypt = AESUtil.decode(encrypt_code);
            // 合法
            if (user_id.equals(id_decrypt)) {

                Message message = new Message();
                List<Message> messageList = dataMapper.getMessageByConditionIf(message);

                return ResultUtil.success(messageList);
            }
            // 不合法
            else {
                return ResultUtil.illegalAccess();
            }
        }
        catch (BadPaddingException e){
            // 解密失败
            return ResultUtil.illegalAccess();
        }
    }

    @Override
    public Result like(String user_id, String encrypt_code, String message_id) {
        try {
            // 验证用户
            String id_decrypt = AESUtil.decode(encrypt_code);
            // 合法
            if (user_id.equals(id_decrypt)) {

                // message_id
                int int_id = Integer.valueOf(message_id).intValue();

                int res_code =  dataMapper.updateTotalLike(int_id);

                if (res_code == 1){

                    return ResultUtil.success();
                }
                else {
                    return ResultUtil.messageNotExist();
                }
            }
            // 不合法
            else {
                return ResultUtil.illegalAccess();
            }

        }
        catch (BadPaddingException e){
            // 解密失败
            return ResultUtil.illegalAccess();
        }
    }

}
