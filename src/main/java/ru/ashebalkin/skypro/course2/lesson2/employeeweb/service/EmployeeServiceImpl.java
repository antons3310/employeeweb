package ru.ashebalkin.skypro.course2.lesson2.employeeweb.service;

import org.springframework.stereotype.Service;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.exception.EmployeeAlreadyExistsException;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.exception.EmployeeNotFoundException;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.resource.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeBook;

    public EmployeeServiceImpl() {
        employeeBook = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {

        if (!employeeBook.containsKey(firstName + lastName)) {
            Employee newEmployee = new Employee(firstName, lastName);
            employeeBook.put(firstName + lastName, newEmployee);
            return newEmployee;
        } else {
            throw new EmployeeAlreadyExistsException();
        }
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {

        if (employeeBook.containsKey(firstName + lastName)) {
            return employeeBook.remove(firstName + lastName);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployeeByFIO(String firstName, String lastName) {

        if (employeeBook.containsKey(firstName + lastName)) {
            return employeeBook.get(firstName + lastName);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Collection<Employee> getEmployeeList() {
        return employeeBook.values();
    }

}