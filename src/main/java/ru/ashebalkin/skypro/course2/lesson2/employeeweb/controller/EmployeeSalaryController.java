package ru.ashebalkin.skypro.course2.lesson2.employeeweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.resource.Employee;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.service.EmployeeSalaryService;

import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/departments")
public class EmployeeSalaryController {

    private final EmployeeSalaryService employeeSalaryService;

    public EmployeeSalaryController(EmployeeSalaryService employeeSalaryService) {
        this.employeeSalaryService = employeeSalaryService;
    }

    @GetMapping
    public String helloMessage() {
        return "Страница работы с зарплатой сотрудников";
    }

    @GetMapping("/max-salary")
    public String getMaxSalaryByDepartment(@RequestParam("departmentId") Integer deparmentId) {
        return "Максимальная зарплата сотрудника отдела с ИД: " + deparmentId + " = " + employeeSalaryService.getMaxSalaryByDepartment(deparmentId);
    }

    @GetMapping("/min-salary")
    public String getMinSalaryByDepartment(@RequestParam("departmentId") Integer deparmentId) {
        return "Минимальная зарплата сотрудника отдела с ИД: " + deparmentId + " = " + employeeSalaryService.getMinSalaryByDepartment(deparmentId);
    }

    @GetMapping(value = "/all", params = {"departmentId"})
    public Collection<Employee> getEmployeeListByDepartment(@RequestParam(value = "departmentId", required = false) Integer deparmentId) {
        return employeeSalaryService.getEmployeeListByDepartment(deparmentId);
    }

    @GetMapping("/all")
    public HashMap<Integer, Collection<Employee>> getEmployeeListByDepartment() {
        return employeeSalaryService.getEmployeeListByDepartment();
    }
}
