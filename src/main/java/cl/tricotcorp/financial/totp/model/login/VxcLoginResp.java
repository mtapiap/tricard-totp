
package cl.tricotcorp.financial.totp.model.login;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "codError",
        "error_description",
        "exception",
        "code",
        "description",
        "processId"
})
@Generated("jsonschema2pojo")
public class VxcLoginResp {

    @JsonProperty("codError")
    private Integer errorCode;
    @JsonProperty("error_description")
    private String errorDescription;
    @JsonProperty("exception")
    private String error;
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("processId")
    private String processId;

    @JsonProperty("codError")
    public Integer getErrorCode() {
        return errorCode;
    }

    @JsonProperty("codError")
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @JsonProperty("error_description")
    public String getErrorDescription() {
        return errorDescription;
    }

    @JsonProperty("error_description")
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @JsonProperty("exception")
    public String getError() {
        return error;
    }

    @JsonProperty("exception")
    public void setError(String error) {
        this.error = error;
    }

    @JsonProperty("code")
    public Integer getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(Integer code) {
        this.code = code;
    }

    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
    }

    @JsonProperty("processId")
    public String getProcessId() {
        return processId;
    }

    @JsonProperty("processId")
    public void setProcessId(String processId) {
        this.processId = processId;
    }

}