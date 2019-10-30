package com.zjw.java8;


import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zhang jiawei
 * @date 2019/7/22 17:46
 */
public class CollectDemo {





    public static void main(String[] args) {

        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));


     //   IntSummaryStatistics statistics = Stream.of(persons).collect(Collectors.summarizingInt());


        IntSummaryStatistics ageSummary = persons.stream().collect(Collectors.summarizingInt(p -> p.age));

        System.out.println(ageSummary);

        Optional<Integer> max = Arrays.asList(1, 2, 3, 4, 5).stream()
                .max((o1, o2) -> o2 - o1);
        System.out.println("max:" + max.get());//

    }

    static class Person {


        String name;
        public int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString() {
            return name;
        }
    }

}
