package org.example;

import java.util.Arrays;
import java.util.Comparator;

class Employee {
    String name;
    double salary;
    int year;
    int month;
    int day;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static Comparator<Employee> dateComparator = (e1, e2) -> {
        return (e1.year != e2.year) ? Integer.compare(e1.year, e2.year) :
                (e1.month != e2.month) ? Integer.compare(e1.month, e2.month) :
                        Integer.compare(e1.day, e2.day);
    };
}

class Manager extends Employee {
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }

    // Метод повышения зарплаты для всех сотрудников, кроме руководителей
    public static void raiseSalary(Employee[] employees, double percentage) {
        for (Employee employee : employees) {
            if (!(employee instanceof Manager)) {
                employee.salary += employee.salary * percentage / 100;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Иван", 50000, 2020, 5, 20);
        employees[1] = new Manager("Ольга", 70000, 2024, 3, 15);
        employees[2] = new Employee("Анна", 60000, 2021, 7, 10);

        Manager.raiseSalary(employees, 10);

        for (Employee employee : employees) {
            System.out.println(employee.name + ": " + employee.salary);
        }
    }
}
