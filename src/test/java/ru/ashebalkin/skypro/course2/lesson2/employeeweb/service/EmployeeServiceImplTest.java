package ru.ashebalkin.skypro.course2.lesson2.employeeweb.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.exception.EmployeeAlreadyExistsException;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.exception.EmployeeNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static ru.ashebalkin.skypro.course2.lesson2.employeeweb.constants.EmployeeTestConstants.*;

public class EmployeeServiceImplTest {

    private EmployeeServiceImpl out;

    @BeforeEach
    public void initTestService() {
        final EmployeeCheckInputDataServiceImpl ds = new EmployeeCheckInputDataServiceImpl();
        out = new EmployeeServiceImpl(ds);
    }

    @Test
    public void addExistingEmployeeTest() {
        assertThrows(EmployeeAlreadyExistsException.class, () -> out.addEmployee(EXISTING_EMPLOYEE_FIRST_NAME, EXISTING_EMPLOYEE_LAST_NAME));
    }

    @Test
    public void addExistingEmployeeWithDepartmentAndSalaryTest() {
        assertThrows(EmployeeAlreadyExistsException.class, () -> out.addEmployee(EXISTING_EMPLOYEE_FIRST_NAME, EXISTING_EMPLOYEE_LAST_NAME, EXISTING_EMPLOYEE_DEPARTMENT, EXISTING_EMPLOYEE_SALARY));
    }

    @Test
    public void addNewEmployeeTest() {
        assertEquals(out.addEmployee(NEW_EMPLOYEE_FIRST_NAME, NEW_EMPLOYEE_LAST_NAME), out.findEmployeeByFIO(NEW_EMPLOYEE_FIRST_NAME, NEW_EMPLOYEE_LAST_NAME));
    }

    @Test
    public void addNewEmployeeWithDepartmentAndSalaryTest() {
        assertEquals(out.addEmployee(NEW_EMPLOYEE_FIRST_NAME, NEW_EMPLOYEE_LAST_NAME, NEW_EMPLOYEE_DEPARTMENT, NEW_EMPLOYEE_SALARY), out.findEmployeeByFIO(NEW_EMPLOYEE_FIRST_NAME, NEW_EMPLOYEE_LAST_NAME));
    }

    @Test
    public void findNewEmployeeByFIOTest() {
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeByFIO(NEW_EMPLOYEE_FIRST_NAME, NEW_EMPLOYEE_LAST_NAME));
    }

    @Test
    public void findExistingEmployeeByFIOTest() {
        assertEquals(EXISTING_EMPLOYEE, out.findEmployeeByFIO(EXISTING_EMPLOYEE_FIRST_NAME, EXISTING_EMPLOYEE_LAST_NAME));
    }

    @Test
    public void deleteNewEmployeeByFIOTest() {
        assertThrows(EmployeeNotFoundException.class, () -> out.deleteEmployee(NEW_EMPLOYEE_FIRST_NAME, NEW_EMPLOYEE_LAST_NAME));
    }

    @Test
    public void deleteExistingEmployeeByFIOTest() {
        assertEquals(EXISTING_EMPLOYEE, out.deleteEmployee(EXISTING_EMPLOYEE_FIRST_NAME, EXISTING_EMPLOYEE_LAST_NAME));
    }

    @Test
    public void getAllEmployeeListFullListTest() {
        assertTrue(EMPLOYEE_BOOK_TRUE.containsAll(out.getEmployeeList()));
    }

    @Test
    public void getAllEmployeeWrongListTest() {
        assertFalse(EMPLOYEE_BOOK_FALSE.containsAll(out.getEmployeeList()));
    }

}
