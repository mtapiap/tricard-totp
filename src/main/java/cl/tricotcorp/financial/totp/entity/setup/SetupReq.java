
package cl.tricotcorp.financial.totp.entity.setup;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rut",
    "password"
})
@Generated("jsonschema2pojo")
public class SetupReq {

    @JsonProperty("rut")
    private String rut;
    @JsonProperty("password")
    private String password;

    @JsonProperty("rut")
    public String getRut() {
        return rut;
    }

    @JsonProperty("rut")
    public void setRut(String rut) {
        this.rut = rut;
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
