package com.treehole.controller;

import com.treehole.res.Result;
import com.treehole.service.TreeholeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//POST方法：
//        * 请求的结果有持续性的副作用，例如，数据库内添加新的数据行。
//        * 若使用GET方法，则表单上收集的数据可能让URL过长。
//        * 要传送的数据不是采用7位的ASCII编码。
//
//        GET方法：
//        * 请求是为了查找资源，HTML表单数据仅用来帮助搜索。
//        * 请求结果无持续性的副作用。
//        * 收集的数据及HTML表单内的输入字段名称的总长不超过1024个字符。
//
//        GET一般用于获取/查询资源信息，而POST一般用于更新资源信息。

/**
 * @author W.Q.
 * @project Treehole
 * @package com.treehole.controller
 * @date 2021.01.07
 */
@RestController
public class DataController {

    @Autowired
    private TreeholeService treeholeService;

    // 1.用户注册
    @PostMapping("treehole/register")
    public Result register(@RequestParam("user_name") String user_name,
                           @RequestParam("phone") String phone,
                           @RequestParam("password") String password,
                           @RequestParam("face_url") String face_url) {
        return treeholeService.register(user_name, phone, password, face_url);
    }

    // 2.用户登录
    @PostMapping("treehole/login")
    public Result login(@RequestParam("phone") String phone,
                        @RequestParam("password") String password) {
        return treeholeService.login(phone, password);
    }

    // 3.发布树洞
    @PostMapping("treehole/publicMessage")
    public Result publicMessage(@RequestParam("user_id") String user_id,
                                @RequestParam("encrypt_code") String encrypt_code,
                                @RequestParam("content") String content,
                                @RequestParam("send_timestamp") String send_timestamp) {
        return treeholeService.publicMessage(user_id, encrypt_code, content, send_timestamp);
    }

    // 4.我的树洞
    @PostMapping("treehole/getMyAllMessage")
    public Result getMyAllMessage(@RequestParam("user_id") String user_id,
                                  @RequestParam("encrypt_code") String encrypt_code) {
        return treeholeService.getMyAllMessage(user_id, encrypt_code);
    }

    // 5.删除树洞
    @PostMapping("treehole/deleteMessage")
    public Result deleteMessage(@RequestParam("user_id") String user_id,
                                @RequestParam("encrypt_code") String encrypt_code,
                                @RequestParam("message_id") String message_id) {
        return treeholeService.deleteMessage(user_id, encrypt_code, message_id);
    }

    // 6.树洞广场
    // 由于id经过BASE64和AES加密后，出现+，在使用GET请求时会错误地解析+，故使用POST
    @PostMapping("treehole/getAllMessage")
    public Result getAllMessage(@RequestParam("user_id") String user_id,
                                @RequestParam("encrypt_code") String encrypt_code) {
        return treeholeService.getAllMessage(user_id, encrypt_code);
    }

    // 7.点赞
    @PostMapping("treehole/like")
    public Result like(@RequestParam("user_id") String user_id,
                       @RequestParam("encrypt_code") String encrypt_code,
                       @RequestParam("message_id") String message_id) {
        return treeholeService.like(user_id, encrypt_code, message_id);
    }
}
