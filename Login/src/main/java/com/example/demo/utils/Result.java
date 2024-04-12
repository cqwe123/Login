package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;
    public static <E> Result<E> success(E date){
        return new Result<E>(0,"操作成功",date);
    }
    public static Result success(){
        return new Result(0,"操作成功",null);
    }
    public static Result error(String message){
        return new Result(1,message,null);
    }
}
