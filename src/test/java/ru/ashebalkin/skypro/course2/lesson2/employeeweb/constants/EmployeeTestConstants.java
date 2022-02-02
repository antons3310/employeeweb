package ru.ashebalkin.skypro.course2.lesson2.employeeweb.constants;

import ru.ashebalkin.skypro.course2.lesson2.employeeweb.resource.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class EmployeeTestConstants {

    public static final Employee EXISTING_EMPLOYEE = new Employee("Шебалкин", "Антон");
    public static final String EXISTING_EMPLOYEE_FIRST_NAME = "Шебалкин";
    public static final String EXISTING_EMPLOYEE_LAST_NAME = "Антон";
    public static final int EXISTING_EMPLOYEE_DEPARTMENT = 1;
    public static final double EXISTING_EMPLOYEE_SALARY = 25874.75;

    public static final Employee NEW_EMPLOYEE = new Employee("Курчатов", "Курчат");
    public static final String NEW_EMPLOYEE_FIRST_NAME = "Курчатов";
    public static final String NEW_EMPLOYEE_LAST_NAME = "Курчат";
    public static final int NEW_EMPLOYEE_DEPARTMENT = 5;
    public static final double NEW_EMPLOYEE_SALARY = 555555.75;

    public static final Collection<Employee> EMPLOYEE_BOOK_TRUE = List.of(
            new Employee("Шебалкин", "Антон", 1, 25874.75),
            new Employee("Петрова", "Алина", 1, 57412.49),
            new Employee("Епифанов", "Светлана", 2, 85221.17),
            new Employee("Михайлова", "Татьяна", 2, 17458.50),
            new Employee("Михайлова", "Ольга", 3, 36000.00),
            new Employee("Павлов", "Алексей", 3, 48756.88),
            new Employee("Новиков", "Андрей", 4, 54898.44),
            new Employee("Дядюра", "Дмитрий", 4, 478844.72),
            new Employee("Ломака", "Сергей", 5, 58114.13),
            new Employee("Грошев", "Алексей", 5, 87444.55)
    );

    public static final Collection<Employee> EMPLOYEE_BOOK_FALSE = List.of(
            new Employee("Шебалкин", "Антон", 1, 25874.75),
            new Employee("Петрова", "Алина", 1, 57412.49),
            new Employee("Епифанов", "Светлана", 2, 85221.17),
            new Employee("Ломака", "Сергей", 5, 58114.13),
            new Employee("Грошев", "Алексей", 5, 87444.55)
    );

    public static final int DEPARTMENT_1 = 1;
    public static final int DEPARTMENT_4 = 4;
    public static final double MAX_SALARY_DEPARTMENT_1 = 57412.49;
    public static final double MIN_SALARY_DEPARTMENT_4 = 54898.44;
    public static final int ILLEGAL_DEPARTMENT = 6;

    public static final Collection<Employee> EMPLOYEE_DEPARTMENT_1 = List.of(
            new Employee("Шебалкин", "Антон", 1, 25874.75),
            new Employee("Петрова", "Алина", 1, 57412.49)
    );

    public static final Map<Integer, Collection<Employee>> EMPLOYEE_BOOK_MAP_TRUE = Map.ofEntries(
            entry(1, List.of(
                    new Employee("Шебалкин", "Антон", 1, 25874.75),
                    new Employee("Петрова", "Алина", 1, 57412.49))),
            entry(2, List.of(
                    new Employee("Епифанов", "Светлана", 2, 85221.17),
                    new Employee("Михайлова", "Татьяна", 2, 17458.50))),
            entry(3, List.of(
                    new Employee("Михайлова", "Ольга", 3, 36000.00),
                    new Employee("Павлов", "Алексей", 3, 48756.88))),
            entry(4, List.of(
                    new Employee("Новиков", "Андрей", 4, 54898.44),
                    new Employee("Дядюра", "Дмитрий", 4, 478844.72))),
            entry(5, List.of(
                    new Employee("Ломака", "Сергей", 5, 58114.13),
                    new Employee("Грошев", "Алексей", 5, 87444.55)))
    );

    public static final Map<Integer, Collection<Employee>> EMPLOYEE_BOOK_MAP_FALSE = Map.ofEntries(
            entry(1, List.of(
                    new Employee("Шебалкин", "Антон", 1, 25874.75),
                    new Employee("Петрова", "Алина", 1, 57412.49))),
            entry(2, List.of(
                    new Employee("Епифанов", "Светлана", 2, 85221.17),
                    new Employee("Михайлова", "Татьяна", 2, 17458.50))),
            entry(3, List.of(
                    new Employee("Михайлова", "Ольга", 3, 36000.00),
                    new Employee("Павлов", "Алексей", 3, 48756.88))),
            entry(5, List.of(
                    new Employee("Ломака", "Сергей", 5, 58114.13),
                    new Employee("Грошев", "Алексей", 5, 87444.55)))
    );
}
