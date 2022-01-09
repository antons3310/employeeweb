package ru.ashebalkin.skypro.course2.lesson2.employeeweb.service;

import ru.ashebalkin.skypro.course2.lesson2.employeeweb.resource.Employee;

import java.util.Collection;
import java.util.HashMap;

public interface EmployeeSalaryService {
    Double getMaxSalaryByDepartment(Integer deparmentId);

    Double getMinSalaryByDepartment(Integer deparmentId);

    Collection<Employee> getEmployeeListByDepartment(Integer deparmentId);

    HashMap<Integer, Collection<Employee>> getEmployeeListByDepartment();

}
