package ru.ashebalkin.skypro.course2.lesson2.employeeweb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "В переданной строке не должно содержаться чисел и других запрещенных символов")
public class EmployeeInputTextErrorException extends RuntimeException {

    public EmployeeInputTextErrorException() {
        super("В переданной строке не должно содержаться чисел и других запрещенных символов");
    }

    public EmployeeInputTextErrorException(String message) {
        super(message);
    }

    public EmployeeInputTextErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeInputTextErrorException(Throwable cause) {
        super(cause);
    }
}
