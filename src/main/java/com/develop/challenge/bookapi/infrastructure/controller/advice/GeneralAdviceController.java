package com.develop.challenge.bookapi.infrastructure.controller.advice;

import com.develop.challenge.bookapi.domain.exception.BusinessException;
import com.develop.challenge.bookapi.domain.exception.DataNotFoundException;
import com.develop.challenge.bookapi.domain.exception.NotificationCodeType;
import com.develop.challenge.bookapi.infrastructure.exception.TechnicalException;
import com.develop.challenge.bookapi.infrastructure.exception.TechnicalNotificationCodeType;
import com.develop.challenge.bookapi.infrastructure.exception.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

import static com.develop.challenge.bookapi.domain.exception.NotificationCodeType.BOOK_API_UNEXPECTED_EXCEPTION;

@Slf4j
@ControllerAdvice
public class GeneralAdviceController extends ResponseEntityExceptionHandler {

    private static final List<ErrorDescriptor> ERROR_CATALOG = new ArrayList<>();

    static {
        ERROR_CATALOG.add(new ErrorDescriptor(DataNotFoundException.class, HttpStatus.NOT_FOUND));
        ERROR_CATALOG.add(new ErrorDescriptor(UnauthorizedException.class,
                HttpStatus.UNAUTHORIZED));
    }

    private ErrorDescriptor findDescriptorByException(Exception exception) {
        return ERROR_CATALOG.stream()
                .filter(errorDescriptor -> errorDescriptor.getExceptionType().equals(exception.getClass()))
                .findFirst()
                .orElse(
                        new ErrorDescriptor(null, HttpStatus.INTERNAL_SERVER_ERROR)
                );
    }

    @ExceptionHandler(BusinessException.class)
    public final ResponseEntity<Notification> handleBusinessExceptions(BusinessException businessException) {
        log.error(businessException.getMessage(), businessException);
        ErrorDescriptor errorDescriptor = findDescriptorByException(businessException);
        NotificationCodeType notificationCode = businessException.getNotificationCode();
        Notification notification = new Notification(notificationCode.getMessage(), notificationCode.getCode());
        return ResponseEntity.status(errorDescriptor.getHttpStatus()).body(notification);
    }

    @ExceptionHandler(TechnicalException.class)
    public final ResponseEntity<Notification> handleBusinessExceptions(TechnicalException technicalException) {
        log.error(technicalException.getMessage(), technicalException);
        ErrorDescriptor errorDescriptor = findDescriptorByException(technicalException);
        TechnicalNotificationCodeType technicalNotificationCode = technicalException.getTechnicalNotificationCode();
        Notification notification = new Notification(technicalNotificationCode.getMessage(), technicalNotificationCode.getCode());
        return ResponseEntity.status(errorDescriptor.getHttpStatus()).body(notification);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Notification> handleUnexpectedExceptions(Exception exception) {
        log.error(exception.getMessage(), exception);
        Notification notification = new Notification(BOOK_API_UNEXPECTED_EXCEPTION.getMessage(), BOOK_API_UNEXPECTED_EXCEPTION.getCode());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(notification);
    }

}
