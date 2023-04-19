package cl.tricotcorp.financial.totp.exception;

/**
 * Created by Voxcom S.A. on July, 2019
 * Email : contacto@voxcom.cl
 */
public class ApiNotFoundException extends RuntimeException{

    public ApiNotFoundException(String message) {
        super(message);
    }

    public ApiNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiNotFoundException(Throwable cause) {
        super(cause);
    }
}