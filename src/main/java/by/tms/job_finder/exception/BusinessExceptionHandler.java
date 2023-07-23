package by.tms.job_finder.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@ControllerAdvice
@Slf4j
public class BusinessExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ModelAndView onApplicationException(BusinessException e) {
        log.warn("Application error: {}", e.toString());
        return new ModelAndView("error", Map.of(
                "error", e.getMessage()
        ));
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView onException(Exception e) {
        log.error("Unknown error:", e);
        return new ModelAndView("error", Map.of(
                "error", "Неизвестная ошибка"
        ));
    }
}
