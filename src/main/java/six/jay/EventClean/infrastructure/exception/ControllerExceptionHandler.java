package six.jay.EventClean.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<Map<String,String>> handleDuplicateEventExceptions(DuplicateEventException ex){
            Map<String,String> response = new HashMap<>();
            response.put("Error: ", ex.getMessage());
            response.put("Message: ","Por favor, insira um identificador valido para o evento");
            return new  ResponseEntity<>(response,HttpStatus.CONFLICT);
    }
}
