package com.zjw.java8;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhang jiawei
 * @date 2019/6/24 18:30
 */
public class Lambda {
    public static void main(String[] args) {
        Runnable noArguments = () -> System.out.println("hello World!");
        String[] nameArr = new String[]{"张佳伟","傻逼","帅逼","丰胸","傻逼"};
        List<String> nameList = Arrays.asList(nameArr);
        Integer count = Math.toIntExact(nameList.stream().filter(data -> data.equals("傻逼")).count());
        System.out.println(count);
        nameList.stream().filter(data -> {
            System.out.println(data);
            return data.equals("傻逼");
        }).count();

    }
}
