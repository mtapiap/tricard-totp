package cl.tricotcorp.financial.totp.exception;

/**
 * Created by Voxcom S.A. on July, 2019
 * Email : contacto@voxcom.cl
 */
public class ApiErrorResponse {

    //    private int status;
//    private String message;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
//    private LocalDateTime timeStamp;
    private int codError;
    private String msgError;

    public ApiErrorResponse(int codError, String msgError) {
        this.codError = codError;
        this.msgError = msgError;
    }

    public int getCodError() {
        return codError;
    }

    public void setCodError(int codError) {
        this.codError = codError;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    public ApiErrorResponse() {
    }

}