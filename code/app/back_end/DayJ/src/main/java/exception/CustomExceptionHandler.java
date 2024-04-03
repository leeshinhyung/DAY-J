package exception;

import com.capstone.dayj.friendGroup.FriendGroupNotFoundException;
import com.capstone.dayj.plan.PlanNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(FriendGroupNotFoundException.class)
    protected ResponseEntity<?> handleFriendGroupNotFoundException(FriendGroupNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(PlanNotFoundException.class)
    protected ResponseEntity<?> handlePlanNotFoundException(PlanNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}