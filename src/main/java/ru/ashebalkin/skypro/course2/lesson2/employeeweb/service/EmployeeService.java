package ru.ashebalkin.skypro.course2.lesson2.employeeweb.service;

import ru.ashebalkin.skypro.course2.lesson2.employeeweb.resource.Employee;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    String deleteEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);
}
