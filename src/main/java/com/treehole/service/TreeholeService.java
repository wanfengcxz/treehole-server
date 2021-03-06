package com.treehole.service;

import com.treehole.util.Result;

/**
 * @author W.Q
 * @project treehole
 * @package com.treehole.entity
 * @date 2021.01.14
 * @description 业务逻辑层 提供业务逻辑接口
 */
public interface TreeholeService {

    // 1.注册
    public Result register(String user_name, String phone, String password, String face_url);

    // 2.登录
    public Result login( String phone, String password);

    // 3.发布树洞
    public Result publicMessage(String user_id, String encrypt_code, String content, String send_timestamp);

    // 4.获取我的树洞
    public Result getMyAllMessage(String user_id, String encrypt_code);

    // 5.删除树洞
    public Result deleteMessage(String user_id, String encrypt_code, String message_id);

    // 6.获取所有树洞
    public Result getAllMessage(String user_id, String encrypt_code);

    // 7.点赞
    public Result like(String user_id, String encrypt_code, String message_id);


}
