package suleman.example.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
public class GlobalException {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ExceptionResponse> EmployeeNotFoundException(EmployeeNotFoundException ex){
		
		ExceptionResponse exceptionresponse = new ExceptionResponse(
				ex.getMessage(),
				LocalDateTime.now()
				);
		
		return new ResponseEntity<>(exceptionresponse , HttpStatus.OK);
		
	}
	
	@ExceptionHandler(EmployeeAllReadyExist.class)
	public ResponseEntity<ExceptionResponse> EmployeeAllReadyExistException(EmployeeAllReadyExist ex){
		
		ExceptionResponse exceptionresponse = new ExceptionResponse(
				ex.getMessage(),
				LocalDateTime.now()
				);
		
		return new ResponseEntity<>(exceptionresponse , HttpStatus.OK);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> Exception(Exception ex){
		
		ExceptionResponse exceptionresponse = new ExceptionResponse(
				ex.getMessage(),
				LocalDateTime.now()
				);
		
		return new ResponseEntity<>(exceptionresponse , HttpStatus.OK);
		
	}

	
}
