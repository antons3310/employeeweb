package ru.ashebalkin.skypro.course2.lesson2.employeeweb.resource;

import java.util.Objects;

public class Employee {
    private final String firstName;                 //Имя
    private final String lastName;                  //Фамилия


    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
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
