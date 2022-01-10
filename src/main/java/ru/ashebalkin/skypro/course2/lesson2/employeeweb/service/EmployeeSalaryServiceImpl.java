package ru.ashebalkin.skypro.course2.lesson2.employeeweb.service;

import org.springframework.stereotype.Service;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.exception.EmployeeNotFoundException;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.resource.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeSalaryServiceImpl implements EmployeeSalaryService {
    private final EmployeeService employeeService;

    public EmployeeSalaryServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Double getMaxSalaryByDepartment(Integer deparmentId) {

        Collection<Employee> employees = employeeService.getEmployeeList();

        Employee fndE = employees.stream().
                filter(employee -> employee.getDepartmentId() == deparmentId).
                max(Comparator.comparingDouble(Employee::getSalaryAmount)).
                orElseThrow(() -> new EmployeeNotFoundException("Сотрудник для отдела: " + deparmentId + " не найден"));

        return fndE.getSalaryAmount();

    }

    @Override
    public Double getMinSalaryByDepartment(Integer deparmentId) {

        Collection<Employee> employees = employeeService.getEmployeeList();

        Employee fndE = employees.stream().
                filter(employee -> employee.getDepartmentId() == deparmentId).
                min(Comparator.comparingDouble(Employee::getSalaryAmount)).
                orElseThrow(() -> new EmployeeNotFoundException("Сотрудник для отдела: " + deparmentId + " не найден"));

        return fndE.getSalaryAmount();

    }

    @Override
    public Collection<Employee> getEmployeeListByDepartment(Integer deparmentId) {
        Collection<Employee> employees = employeeService.getEmployeeList();
        return employees.stream().
                filter(employee -> Objects.equals(employee.getDepartmentId(), deparmentId)).
                collect(Collectors.toList());
    }

    @Override
    public HashMap<Integer, Collection<Employee>> getEmployeeListByDepartment() {

        HashMap<Integer, Collection<Employee>> workBook = new HashMap<>();

        Collection<Employee> employees = employeeService.getEmployeeList();
        employees.forEach(employee -> workBook.put(employee.getDepartmentId(), getEmployeeListByDepartment(employee.getDepartmentId())));
        return workBook;
    }
}
