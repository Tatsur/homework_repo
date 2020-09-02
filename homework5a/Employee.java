package ru.geekbrains.java_one.homework.homework5a;

public class Employee {
    private final String fullName;
    private final String position;
    private final String email;
    private final String phoneNumber;
    private final int salary;
    private final int age;

    public Employee(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    void showInfo() {
        System.out.println("\nFull name: " + fullName);
        System.out.println("Position: " + position);
        System.out.println("Email: " + email);
        System.out.println("Phone number " + phoneNumber);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);
        System.out.println("__________________________");
    }

    public int getAge() {
        return age;
    }

}
