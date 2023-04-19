package cl.tricotcorp.financial.totp.exception;

/**
 * Created by Voxcom S.A. on July, 2019
 * Email : contacto@voxcom.cl
 */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> handleException(ApiNotFoundException ane){
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setCodError(HttpStatus.NOT_FOUND.value());
        errorResponse.setMsgError(ane.getMessage());
        //errorResponse.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<ApiErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> handleException(Exception ex){
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setCodError(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMsgError(ex.getLocalizedMessage());
        //errorResponse.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<ApiErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
    }



/*    @ExceptionHandler
    protected ResponseEntity<ApiErrorResponse> handleConstraintViolation(DuplicateKeyException ex) {
        ApiErrorResponse errorResponse = new ApiErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<ApiErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
    }*/
}