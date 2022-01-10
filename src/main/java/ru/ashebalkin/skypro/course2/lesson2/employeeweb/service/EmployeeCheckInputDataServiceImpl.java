package ru.ashebalkin.skypro.course2.lesson2.employeeweb.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.ashebalkin.skypro.course2.lesson2.employeeweb.exception.EmployeeInputTextErrorException;

@Service
public class EmployeeCheckInputDataServiceImpl implements EmployeeCheckInputDataService {

    @Override
    public void checkTextData(String str) {

        if (!StringUtils.isAlpha(str)) {
            throw new EmployeeInputTextErrorException("В параметре " + str + " содержаться запрещенные символы");
        }

    }

    @Override
    public String checkCapitalLetters(String str) {

        return StringUtils.capitalize(str);

    }

}
