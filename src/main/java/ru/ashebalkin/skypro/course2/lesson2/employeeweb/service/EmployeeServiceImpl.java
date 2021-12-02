package ru.ashebalkin.skypro.course2.lesson2.employeeweb.service;

import org.springframework.stereotype.Service;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.EmployeeArrayIsFullException;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.EmployeeNotFoundException;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.resource.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Employee[] employees = new Employee[5];

    @Override
    public String addEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        boolean isAdd = false;

        for (int i = 0; i < employees.length; i = i + 1) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                isAdd = true;
                break;
            }
        }

        if (isAdd) {
            return newEmployee.toString();
        } else {
            throw new EmployeeArrayIsFullException();
        }
    }

    @Override
    public String deleteEmployee(String firstName, String lastName) {
        Employee e = null;
        for (int i = 0; i < employees.length; i = i + 1) {
            if (employees[i] != null) {
                if (employees[i].equals(firstName, lastName)) {
                    e = employees[i];
                    employees[i] = null;
                    break;
                }
            }
        }
        if (e != null) {
            return e.toString();
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = null;
        for (Employee value : employees) {
            if (value != null) {
                if (value.equals(firstName, lastName)) {
                    employee = value;
                    break;
                }
            }
        }
        if (employee != null) {
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

}


