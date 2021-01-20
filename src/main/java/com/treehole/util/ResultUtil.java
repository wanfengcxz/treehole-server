package com.treehole.util;

/**
 * @author W.Q
 * @project treehole
 * @package com.treehole.res
 * @date 2021.01.08
 * @description 通过枚举封装了几种预定的访问结果
 */
enum ResultEnum {
    //这里是可以自己定义的，方便与前端交互即可

    // 通用
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    INSUFFICIENT_PARAMETERS(1,"参数不足"),
    // 注册
    PHONE_REPEATITION(3,"手机号已注册过"),
    // 发布树洞
    // 获取所有树洞
    // 获取指定用户的所有树洞
    // 点赞
    MESSAGE_NOT_EXIST(4,"树洞消息不存在"),
    USER_NOT_EXIST(5,"用户不存在"),
    PASSWORD_ERROR(6,"密码错误"),
    ILLEGAL_ACCESS(7,"非法访问");


    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

/**
 * @author W.Q
 * @project treehole
 * @package com.treehole.res
 * @date 2021.01.06
 * @description 将枚举变量的信息进一步封装为方法
 */
public class ResultUtil {

    // 未知错误
    public static Result unknownError(){
        Result result = new Result();
        result.setCode(ResultEnum.UNKNOWN_ERROR.getCode());
        result.setMsg(ResultEnum.UNKNOWN_ERROR.getMsg());
        result.setData(null);
        return  result;
    }

    // 请求成功
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    // 请求成功但不带数据
    public static Result success(){
        return success(null);
    }

    // 参数不足
    public static Result insufficientParameters(){
        Result result = new Result();
        result.setCode(ResultEnum.INSUFFICIENT_PARAMETERS.getCode());
        result.setMsg(ResultEnum.INSUFFICIENT_PARAMETERS.getMsg());
        result.setData(null);
        return result;
    }

    // 手机号重复
    public static Result phoneRepeatition(){
        Result result = new Result();
        result.setCode(ResultEnum.PHONE_REPEATITION.getCode());
        result.setMsg(ResultEnum.PHONE_REPEATITION.getMsg());
        result.setData(null);
        return result;
    }

    // 当前树洞消息不存在
    public static Result messageNotExist(){
        Result result = new Result();
        result.setCode(ResultEnum.MESSAGE_NOT_EXIST.getCode());
        result.setMsg(ResultEnum.MESSAGE_NOT_EXIST.getMsg());
        result.setData(null);
        return result;
    }

    // 当前用户不存在
    public static Result userNotExist(){
        Result result = new Result();
        result.setCode(ResultEnum.USER_NOT_EXIST.getCode());
        result.setMsg(ResultEnum.USER_NOT_EXIST.getMsg());
        result.setData(null);
        return result;
    }

    // 当前用户不存在
    public static Result passwordError(){
        Result result = new Result();
        result.setCode(ResultEnum.PASSWORD_ERROR.getCode());
        result.setMsg(ResultEnum.PASSWORD_ERROR.getMsg());
        result.setData(null);
        return result;
    }

    // 非法访问
    public static Result illegalAccess(){
        Result result = new Result();
        result.setCode(ResultEnum.ILLEGAL_ACCESS.getCode());
        result.setMsg(ResultEnum.ILLEGAL_ACCESS.getMsg());
        result.setData(null);
        return result;
    }

}
