package ru.ashebalkin.skypro.course2.lesson2.employeeweb.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.exception.EmployeeNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static ru.ashebalkin.skypro.course2.lesson2.employeeweb.constants.EmployeeTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeSalaryServiceImplTest {

    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    EmployeeSalaryServiceImpl out;

    @Test
    void getMaxSalaryByDepartmentDep1Test() {
        when(employeeServiceMock.getEmployeeList()).thenReturn(EMPLOYEE_BOOK_TRUE);
        assertEquals(MAX_SALARY_DEPARTMENT_1, out.getMaxSalaryByDepartment(DEPARTMENT_1));
    }

    @Test
    void getMinSalaryByDepartmentDep4Test() {
        when(employeeServiceMock.getEmployeeList()).thenReturn(EMPLOYEE_BOOK_TRUE);
        assertEquals(MIN_SALARY_DEPARTMENT_4, out.getMinSalaryByDepartment(DEPARTMENT_4));
    }

    @Test
    void getMinSalaryByDepartmentIllegalDepartmentTest() {
        when(employeeServiceMock.getEmployeeList()).thenReturn(EMPLOYEE_BOOK_TRUE);
        assertThrows(EmployeeNotFoundException.class, () -> out.getMinSalaryByDepartment(ILLEGAL_DEPARTMENT));
    }

    @Test
    void getMaxSalaryByDepartmentIllegalDepartmentTest() {
        when(employeeServiceMock.getEmployeeList()).thenReturn(EMPLOYEE_BOOK_TRUE);
        assertThrows(EmployeeNotFoundException.class, () -> out.getMaxSalaryByDepartment(ILLEGAL_DEPARTMENT));
    }

    @Test
    void getEmployeeListByDepartmentTrueTest() {
        when(employeeServiceMock.getEmployeeList()).thenReturn(EMPLOYEE_BOOK_TRUE);
        assertTrue(EMPLOYEE_DEPARTMENT_1.containsAll(out.getEmployeeListByDepartment(DEPARTMENT_1)));
    }

    @Test
    void getEmployeeListByDepartmentFalseTest() {
        when(employeeServiceMock.getEmployeeList()).thenReturn(EMPLOYEE_BOOK_TRUE);
        assertFalse(EMPLOYEE_DEPARTMENT_1.containsAll(out.getEmployeeListByDepartment(DEPARTMENT_4)));
    }

    @Test
    void getFullEmployeeListByDepartmentTrueTest() {
        when(employeeServiceMock.getEmployeeList()).thenReturn(EMPLOYEE_BOOK_TRUE);
        assertEquals(EMPLOYEE_BOOK_MAP_TRUE, out.getEmployeeListByDepartment());
    }

    @Test
    void getFullEmployeeListByDepartmentFalseTest() {
        when(employeeServiceMock.getEmployeeList()).thenReturn(EMPLOYEE_BOOK_TRUE);
        assertNotEquals(EMPLOYEE_BOOK_MAP_FALSE, out.getEmployeeListByDepartment());
    }

}
