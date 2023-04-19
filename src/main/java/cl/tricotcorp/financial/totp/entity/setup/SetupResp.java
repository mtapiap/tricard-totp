
package cl.tricotcorp.financial.totp.entity.setup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "codError",
        "desError",
        "msgError",
        "processId",
        "phoneNumber"

})
@Generated("jsonschema2pojo")
public class SetupResp {

    @JsonProperty("codError")
    private Integer codError;

    @JsonProperty("desError")
    private String desError;

    @JsonProperty("msgError")
    private String msgError;

    @JsonProperty("processId")
    private String processId;

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

    @JsonProperty("desError")
    public String getDesError() {
        return desError;
    }

    @JsonProperty("desError")
    public void setDesError(String desError) {
        this.desError = desError;
    }

    @JsonProperty("msgError")
    public String getMsgError() {
        return msgError;
    }

    @JsonProperty("msgError")
    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    @JsonProperty("processId")
    public String getProcessId() {
        return processId;
    }

    @JsonProperty("processId")
    public void setProcessId(String processId) {
        this.processId = processId;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() { return phoneNumber; }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}