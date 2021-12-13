package ru.ashebalkin.skypro.course2.lesson2.employeeweb.service;

import org.springframework.stereotype.Service;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.exception.EmployeeAlreadyExistsException;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.exception.EmployeeNotFoundException;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.resource.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employeeBook;


    public EmployeeServiceImpl() {
        employeeBook = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {

        Employee newEmployee = new Employee(firstName, lastName);
        try {
            Employee fndEmployee = findEmployeeByFIO(firstName, lastName);
        } catch (EmployeeNotFoundException exception) {
            employeeBook.add(newEmployee);
            return newEmployee;

        }
        throw new EmployeeAlreadyExistsException();
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {

        Employee fndEmployee = findEmployeeByFIO(firstName, lastName);
        if (fndEmployee != null) {
            employeeBook.remove(fndEmployee);
        }
        return fndEmployee;

    }

    @Override
    public Employee findEmployeeByFIO(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = null;
        for (Employee value : employeeBook) {
            if (value.equals(firstName, lastName)) {
                employee = value;
            }
        }

        if (employee != null) {
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeBook;
    }

}


