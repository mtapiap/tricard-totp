
package cl.tricotcorp.financial.totp.model.login;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "identificationNumber",
        "password"
})
@Generated("jsonschema2pojo")
public class TricotLoginReq {

    @JsonProperty("identificationNumber")
    private String identificationNumber;
    @JsonProperty("password")
    private String password;

    @JsonProperty("identificationNumber")
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    @JsonProperty("identificationNumber")
    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

}