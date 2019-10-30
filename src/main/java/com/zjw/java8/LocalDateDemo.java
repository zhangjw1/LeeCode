package com.zjw.java8;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author zhang jiawei
 * @date 2019/7/27 16:12
 */
public class LocalDateDemo {

    public static void main(String[] args) {
        LocalDate localDate =  LocalDate.now();
        LocalDate date = LocalDate.of(2019,7,27);
        System.out.println(localDate.equals(date));

        LocalDate someDay = LocalDate.ofYearDay(2016,168);
        Long intervalDay = localDate.toEpochDay() - someDay.toEpochDay();
        System.out.println(someDay+ " "+intervalDay);


        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);


    }


}
