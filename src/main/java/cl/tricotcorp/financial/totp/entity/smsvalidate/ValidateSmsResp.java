
package cl.tricotcorp.financial.totp.entity.smsvalidate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "codError",
        "desError",
        "msgError",
        "uri"
//        "secret"
})
@Generated("jsonschema2pojo")
public class ValidateSmsResp {

    @JsonProperty("codError")
    private Integer codError;
    @JsonProperty("desError")
    private String desError;
    @JsonProperty("msgError")
    private String msgError;
    @JsonProperty("uri")
    private String uri;
//    @JsonProperty("secret")
//    private String secret;

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

/*
    @JsonProperty("secret")
    public String getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(String secret) {
        this.secret = secret;
    }
*/
    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }
}