package ru.ashebalkin.skypro.course2.lesson2.employeeweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.resource.Employee;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String helloMessage() {
        return "Страница работы с сотрудниками";
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return "Сотрудник: " + employeeService.addEmployee(firstName, lastName) + " успешно создан";
    }

    @GetMapping("/remove")
    public String deleteEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return "Сотрудник: " + employeeService.deleteEmployee(firstName, lastName) + " успешно удален";
    }

    @GetMapping("/find")
    public Employee findEmployeeByFIO(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.findEmployeeByFIO(firstName, lastName);
    }

    @GetMapping("/get-list")
    public Collection<Employee> getEmployeeList() {
        return employeeService.getEmployeeList();
    }

}