
package cl.tricotcorp.financial.totp.entity.smsvalidate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "processId",
        "code",
        "os"
})
@Generated("jsonschema2pojo")
public class ValidateSmsReq {

    @JsonProperty("id")
    private String id;

    @JsonProperty("processId")
    private String processId;

    @JsonProperty("code")
    private Integer code;

    @JsonProperty("os")
    private String os;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("processId")
    public String getProcessId() {
        return processId;
    }

    @JsonProperty("processId")
    public void setProcessId(String processId) {
        this.processId = processId;
    }

    @JsonProperty("code")
    public Integer getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(Integer code) {
        this.code = code;
    }

    @JsonProperty("os")
    public String getOs() { return os; }

    @JsonProperty("os")
    public void setOs(String os) { this.os = os; }

    @Override
    public String toString() {
        return "ValidateSmsReq{" +
                "id='" + id + '\'' +
                ", processId='" + processId + '\'' +
                ", code=" + code +
                ", os='" + os + '\'' +
                '}';
    }
}