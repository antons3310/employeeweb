package ru.ashebalkin.skypro.course2.lesson2.employeeweb.service;

import org.springframework.stereotype.Service;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.resource.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeSalaryServiceImpl implements EmployeeSalaryService {
    private final EmployeeService employeeService;

    private final HashMap<Integer, Collection<Employee>> workBook;
    private final HashSet<Integer> deparmentList;


    public EmployeeSalaryServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
        workBook = new HashMap<>();
        deparmentList = new HashSet<>();
    }

    @Override
    public Double getMaxSalaryByDepartment(Integer deparmentId) {
        Collection<Employee> employees = employeeService.getEmployeeList();
//        Employee fndE = employees.stream().
//                filter(employee -> employee.getDepartmentId() == deparmentId).
//                max(Comparator.comparingDouble(employee -> employee.getSalaryAmount())).
//                get();
//        return fndE.getSalaryAmount();
        return employees.stream().
                filter(employee -> employee.getDepartmentId() == deparmentId).
                mapToDouble(Employee::getSalaryAmount).
                max().
                getAsDouble();

    }

    @Override
    public Double getMinSalaryByDepartment(Integer deparmentId) {
        Collection<Employee> employees = employeeService.getEmployeeList();
        return employees.stream().
                filter(employee -> Objects.equals(employee.getDepartmentId(), deparmentId)).
                mapToDouble(Employee::getSalaryAmount).min().getAsDouble();
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
        Collection<Employee> employees = employeeService.getEmployeeList();
        employees.forEach(employee -> workBook.put(employee.getDepartmentId(), getEmployeeListByDepartment(employee.getDepartmentId())));
        return workBook;
    }
}
