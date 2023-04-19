
package cl.tricotcorp.financial.totp.entity.clients;

import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "codError",
    "msgError",
    "clients"
})
@Generated("jsonschema2pojo")
public class ClientsResp {

    @JsonProperty("codError")
    private Integer codError;
    @JsonProperty("msgError")
    private String msgError;
    @JsonProperty("clients")
    private List<Clients> clients = null;

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

    @JsonProperty("clients")
    public List<Clients> getClients() {
        return clients;
    }

    @JsonProperty("clients")
    public void setClients(List<Clients> clients) {
        this.clients = clients;
    }

}
