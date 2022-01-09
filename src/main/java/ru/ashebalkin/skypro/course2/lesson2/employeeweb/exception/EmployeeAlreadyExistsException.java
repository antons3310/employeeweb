package ru.ashebalkin.skypro.course2.lesson2.employeeweb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class EmployeeAlreadyExistsException extends RuntimeException {

    public EmployeeAlreadyExistsException() {
        super("Такой сотрудник уже существует.");
    }

    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }

    public EmployeeAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeAlreadyExistsException(Throwable cause) {
        super(cause);
    }

}