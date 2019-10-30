package com.zjw.java8;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author zhang jiawei
 * @date 2019/7/27 14:14
 */
public class OptionalDemo {

    static List<Employee> employess = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        employess.add(new Employee("emp1", 1, "1000"));
        employess.add(new Employee("emp2", 2, "2000"));
        employess.add(new Employee("emp1", 3, "3000"));
        Optional<Employee> employee = getPersonWithId("1000");
        Employee e = employee.orElseThrow(() -> new Exception("emp not found"));
        System.out.println(e.getAge());
    }
    public static Optional<Employee> getPersonWithId(String id) {
        Optional<Employee> employee = employess.stream().filter(e -> (e.getId() == id)).findFirst();
        return employee;
    }

  static  class Employee {


        String name;
        int age;
        String id;

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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Employee(String name, int age, String id) {
            this.name = name;
            this.age = age;
            this.id = id;
        }
    }

}
