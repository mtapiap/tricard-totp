
package cl.tricotcorp.financial.totp.model.smssend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "code",
        "description",
        "phoneNumber"
})
@Generated("jsonschema2pojo")
public class TricotSendSmsResp {

    @JsonProperty("code")
    private Integer code;
    @JsonProperty("description")
    private String description;
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("code")
    public Integer getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(Integer code) {
        this.code = code;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() { return phoneNumber; }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}