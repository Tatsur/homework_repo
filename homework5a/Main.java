package ru.geekbrains.java_one.homework.homework5a;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Fedor Fedorov", "Manager", "fedor.fedorov@fmail.com", "89653488456", 80000, 42);
        employees[1] = new Employee("Ivan Kotov", "Engineer", "iv.kotov@fmail.com", "89464854523", 120000, 27);
        employees[2] = new Employee("Andrew Kositskiy", "Designer", "andrkos@fmail.com", "89134154545", 110000, 35);
        employees[3] = new Employee("Dmitriy Kosoy", "Engineer", "dim.dim@fmail.com", "89134363223", 250000, 45);
        employees[4] = new Employee("Nalalya Antonova", "Designer", "nata45@fmail.com", "89134232222", 130000, 24);
        for (Employee emp :
                employees) {
            if (emp.getAge() > 40) emp.showInfo();
        }
    }
}
