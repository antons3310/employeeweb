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

    private final EmployeeCheckInputDataService employeeCheckInputDataService;

    public EmployeeServiceImpl(EmployeeCheckInputDataService employeeCheckInputDataService) {
        this.employeeCheckInputDataService = employeeCheckInputDataService;
        employeeBook = new HashMap<>();

        employeeBook.put("Шебалкин" + "Антон", new Employee("Шебалкин", "Антон", 1, 25874.75));
        employeeBook.put("Петрова" + "Алина", new Employee("Петрова", "Алина", 1, 57412.49));
        employeeBook.put("Епифанов" + "Светлана", new Employee("Епифанов", "Светлана", 2, 85221.17));
        employeeBook.put("Михайлова" + "Татьяна", new Employee("Михайлова", "Татьяна", 2, 17458.50));
        employeeBook.put("Михайлова" + "Ольга", new Employee("Михайлова", "Ольга", 3, 36000.00));
        employeeBook.put("Павлов" + "Алексей", new Employee("Павлов", "Алексей", 3, 48756.88));
        employeeBook.put("Новиков" + "Андрей", new Employee("Новиков", "Андрей", 4, 54898.44));
        employeeBook.put("Дядюра" + "Дмитрий", new Employee("Дядюра", "Дмитрий", 4, 478844.72));
        employeeBook.put("Ломака" + "Сергей", new Employee("Ломака", "Сергей", 5, 58114.13));
        employeeBook.put("Грошев" + "Алексей", new Employee("Грошев", "Алексей", 5, 87444.55));
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int departmentId, double salaryAmount) {

        employeeCheckInputDataService.checkTextData(firstName);
        employeeCheckInputDataService.checkTextData(lastName);
        firstName = employeeCheckInputDataService.checkCapitalLetters(firstName);
        lastName = employeeCheckInputDataService.checkCapitalLetters(lastName);

        if (!employeeBook.containsKey(firstName + lastName)) {
            Employee newEmployee = new Employee(firstName, lastName, departmentId, salaryAmount);
            employeeBook.put(firstName + lastName, newEmployee);
            return newEmployee;
        } else {
            throw new EmployeeAlreadyExistsException();
        }
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {

        employeeCheckInputDataService.checkTextData(firstName);
        employeeCheckInputDataService.checkTextData(lastName);
        firstName = employeeCheckInputDataService.checkCapitalLetters(firstName);
        lastName = employeeCheckInputDataService.checkCapitalLetters(lastName);


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

        employeeCheckInputDataService.checkTextData(firstName);
        employeeCheckInputDataService.checkTextData(lastName);
        firstName = employeeCheckInputDataService.checkCapitalLetters(firstName);
        lastName = employeeCheckInputDataService.checkCapitalLetters(lastName);

        if (employeeBook.containsKey(firstName + lastName)) {
            return employeeBook.remove(firstName + lastName);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployeeByFIO(String firstName, String lastName) {

        employeeCheckInputDataService.checkTextData(firstName);
        employeeCheckInputDataService.checkTextData(lastName);
        firstName = employeeCheckInputDataService.checkCapitalLetters(firstName);
        lastName = employeeCheckInputDataService.checkCapitalLetters(lastName);

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