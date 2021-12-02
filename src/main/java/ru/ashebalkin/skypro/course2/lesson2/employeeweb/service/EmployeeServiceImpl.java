package ru.ashebalkin.skypro.course2.lesson2.employeeweb.service;

import org.springframework.stereotype.Service;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.resource.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Employee[] employees = new Employee[5];

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);

        for (int i = 0; i < employees.length; i = i + 1) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return employees[i];
            }
        }
        return null;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee e = null;
        for (int i = 0; i < employees.length; i = i + 1) {
            if (employees[i] != null) {
                if (employees[i].equals(firstName, lastName)) {
                    e = employees[i];
                    employees[i] = null;
                    return e;
                }
            }
        }
        return null;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = null;
        for (Employee value : employees) {
            if (value != null) {
                if (value.equals(firstName, lastName)) {
                    employee = value;
                    return employee;
                }
            }
        }
        return null;
    }

}


