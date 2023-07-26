package by.tms.job_finder.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestControllerAdvice
@Slf4j
public class BusinessExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> onApplicationException(BusinessException e) {
        log.warn("Application error: {}", e.toString());
        return new ResponseEntity<Object>(
                "Ошибка бизнес логики", new HttpHeaders(), HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> onException(Exception e) {
        log.error("Unknown error:", e);
        return new ResponseEntity<Object>(
                "Неизвестная ошибка", new HttpHeaders(), HttpStatus.I_AM_A_TEAPOT);
    }
}
