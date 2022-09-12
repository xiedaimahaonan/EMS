package com.uoh.ems.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: XDS
 * @description:通用结果返回类
 * @date:
 */
@Data
public class Result<T> implements Serializable {

    private Integer code; //编码：1成功，0为失败
    private String msg; //错误信息
    private  T data; //数据

    public static <T> Result<T> success(T object) {
        Result<T> r = new Result<T>();
        r.data = object;
        r.code = 1;//成功
        return r;
    }
    //泛型方法的格式：修饰符 <泛型变量> 方法返回值 方法名称(形参列表){}
    public static <T> Result<T> error(String msg) {
        Result r = new Result();
        r.msg = msg;
        r.code = 0;//失败
        return r;
    }


}
