//1. В класс покупателя добавить перечисление с гендерами, добавить в сотрудника свойство «пол» со значением созданного перечисления. Добавить геттеры, сеттеры.

//2. Добавить в основную программу перечисление с праздниками (нет праздника, Новый Год, 8 марта, 23 февраля), написать метод, принимающий массив сотрудников, поздравляющий всех сотрудников с Новым Годом, женщин с 8 марта, а мужчин с 23 февраля, если сегодня соответствующий день.
package org.example;

import java.io.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Calendar;

enum Gender {
    MALE, FEMALE
}

class Employee {
    String name;
    double salary;
    int year;
    int month;
    int day;
    Gender gender;

    public Employee(String name, double salary, int year, int month, int day, Gender gender) {
        this.name = name;
        this.salary = salary;
        this.year = year;
        this.month = month;
        this.day = day;
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static Comparator<Employee> dateComparator = (e1, e2) -> {
        return (e1.year != e2.year) ? Integer.compare(e1.year, e2.year) :
                (e1.month != e2.month) ? Integer.compare(e1.month, e2.month) :
                        Integer.compare(e1.day, e2.day);
    };
}

class Manager extends Employee {
    public Manager(String name, double salary, int year, int month, int day, Gender gender) {
        super(name, salary, year, month, day, gender);
    }

    // Method to raise salary for all employees except managers
    public static void raiseSalary(Employee[] employees, double percentage) {
        for (Employee employee : employees) {
            if (!(employee instanceof Manager)) {
                employee.salary += employee.salary * percentage / 100;
            }
        }
    }
}

enum Holiday {
    NONE, NEW_YEAR, MARCH_8, FEBRUARY_23
}

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Ivan", 50000, 2020, 5, 20, Gender.MALE);
        employees[1] = new Manager("Olga", 70000, 2024, 3, 15, Gender.FEMALE);
        employees[2] = new Employee("Anna", 60000, 2021, 7, 10, Gender.FEMALE);

        Manager.raiseSalary(employees, 10);
        greetEmployees(employees);

        for (Employee employee : employees) {
            System.out.println(employee.name + ": " + employee.salary);
        }
    }

    public static void greetEmployees(Employee[] employees) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1; 
        for (Employee employee : employees) {
            if (month == 1 && day == 1) {
                System.out.println("С Новым Годом!, " + employee.name + "!");
            } else if (month == 3 && day == 8 && employee.getGender() == Gender.FEMALE) {
                System.out.println("С 8 Марта! " + employee.name + "!");
            } else if (month == 2 && day == 23 && employee.getGender() == Gender.MALE) {
                System.out.println("С 23 февраля! " + employee.name + "!");
            }
        }
    }
}
