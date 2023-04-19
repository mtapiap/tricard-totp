
package cl.tricotcorp.financial.totp.entity.smssend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "codError",
    "msgError",
    "phoneNumber"
})
@Generated("jsonschema2pojo")
public class SendSmsResp {

    @JsonProperty("codError")
    private Integer codError;
    @JsonProperty("msgError")
    private String msgError;
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("codError")
    public Integer getCodError() {
        return codError;
    }

    @JsonProperty("codError")
    public void setCodError(Integer codError) {
        this.codError = codError;
    }

    @JsonProperty("msgError")
    public String getMsgError() {
        return msgError;
    }

    @JsonProperty("msgError")
    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() { return phoneNumber; }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    @Override
    public String toString() {
        return "SendSmsResp{" +
                "codError=" + codError +
                ", msgError='" + msgError + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
