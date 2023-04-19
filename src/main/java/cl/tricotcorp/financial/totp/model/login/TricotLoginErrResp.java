
package cl.tricotcorp.financial.totp.model.login;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "error_description",
        "exception"
})
@Generated("jsonschema2pojo")
public class TricotLoginErrResp {

    @JsonProperty("error_description")
    private String errorDescription;
    @JsonProperty("exception")
    private String error;

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

}