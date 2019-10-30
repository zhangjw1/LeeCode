package com.zjw.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhang jiawei
 * @date 2019/7/19 16:21
 */
public class FlapMap {

    public static void main(String[] args) {
        String ss = "Hello";

        String[] aa = ss.split("");
        String[] bb = {"H", "e", "l", "l", "o"};

        String[] strings = {"Hello", "World"};

        //Arrays.stream接收一个数组返回一个流
        List streamList = Arrays.asList(strings).stream().collect(Collectors.toList());
        streamList.forEach(data-> System.out.println(data));

       List x = Stream.of(new String[] {"Hello", "World"}).
               flatMap(str -> Arrays.stream(str.split(""))).
               distinct().collect(Collectors.toList());
        x.forEach(data-> System.out.println(data));

        List y = Stream.of(new String[] {"Hello", "World"}).map(str -> str.split("")).
                flatMap(str -> Arrays.stream(str)).
                distinct().collect(Collectors.toList());
        y.forEach(data-> System.out.println(data));

        List stringList = Arrays.asList(strings).stream().map(str -> str.split("")).
                flatMap(str -> Arrays.stream(str)).
                distinct().
                collect(Collectors.toList());
        stringList.forEach(data-> System.out.println(data));


    }

}
