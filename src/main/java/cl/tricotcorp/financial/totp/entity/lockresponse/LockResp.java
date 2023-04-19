
package cl.tricotcorp.financial.totp.entity.lockresponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "codError",
    "msgError"
})
@Generated("jsonschema2pojo")
public class LockResp {

    @JsonProperty("codError")
    private Integer codError;
    @JsonProperty("msgError")
    private String msgError;

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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LockResp.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("codError");
        sb.append('=');
        sb.append(((this.codError == null)?"<null>":this.codError));
        sb.append(',');
        sb.append("msgError");
        sb.append('=');
        sb.append(((this.msgError == null)?"<null>":this.msgError));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
