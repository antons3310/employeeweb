package ru.ashebalkin.skypro.course2.lesson2.employeeweb.service;

import ru.ashebalkin.skypro.course2.lesson2.employeeweb.resource.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee deleteEmployee(String firstName, String lastName);

    Employee findEmployeeByFIO(String firstName, String lastName);

    List<Employee> getEmployeeList();
}
