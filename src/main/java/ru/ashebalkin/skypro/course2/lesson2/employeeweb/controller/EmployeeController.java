package ru.ashebalkin.skypro.course2.lesson2.employeeweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.EmployeeArrayIsFullException;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.EmployeeNotFoundException;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.resource.Employee;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String helloMessage(){
        return "Страница работы с сотрудниками";
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        Employee employee = employeeService.addEmployee(firstName, lastName);
        if (employee == null) {
            throw new EmployeeArrayIsFullException();
        } else {
            return "Сотрудник: " + employee.toString() + " успешно создан";
        }
    }

    @GetMapping("/remove")
    public String deleteEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){

        Employee employee = employeeService.deleteEmployee(firstName, lastName);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        } else {
            return "Сотрудник: " + employee.toString() + " успешно удален";
        }
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        Employee employee = employeeService.findEmployee(firstName, lastName);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        } else {
            return employee;
        }
    }

}
