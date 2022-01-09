package ru.ashebalkin.skypro.course2.lesson2.employeeweb.resource;

import java.util.Objects;

public class Employee {
    private final String firstName;         //Имя
    private final String lastName;          //Фамилия
    private int departmentId;           //ИД Подразделения
    private double salaryAmount;            //Размер зарплаты сотрудника

    public Employee(String firstName, String lastName) {
        this(firstName, lastName, 0, 0);
    }

    public Employee(String firstName, String lastName, Integer departmentId, double salaryAmount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.salaryAmount = salaryAmount;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public double getSalaryAmount() {
        return salaryAmount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setSalaryAmount(double salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "ФИО - " + lastName + ' ' + firstName;
    }

    public boolean equals(String firstName, String lastName) {
        return getFirstName().equalsIgnoreCase(firstName)
                && getLastName().equalsIgnoreCase(lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }

}