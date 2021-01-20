package com.treehole.util;

/**
 * @author W.Q
 * @project treehole
 * @package com.treehole.res
 * @date 2021.01.08
 * @description 向前端返回数据时提供统一的格式
 */
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    public Result() {

    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
