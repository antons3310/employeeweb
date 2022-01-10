package ru.ashebalkin.skypro.course2.lesson2.employeeweb.service;

import org.springframework.stereotype.Service;


public interface EmployeeCheckInputDataService {
    void checkTextData(String str);

    String checkCapitalLetters(String str);
}
