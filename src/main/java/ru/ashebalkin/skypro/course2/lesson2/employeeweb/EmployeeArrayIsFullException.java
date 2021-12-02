package ru.ashebalkin.skypro.course2.lesson2.employeeweb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeArrayIsFullException extends RuntimeException{
}
