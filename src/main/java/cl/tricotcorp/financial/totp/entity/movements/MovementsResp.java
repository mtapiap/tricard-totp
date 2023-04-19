
package cl.tricotcorp.financial.totp.entity.movements;

import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "codError",
    "msgError",
    "client",
    "movements"
})
@Generated("jsonschema2pojo")
public class MovementsResp {

    @JsonProperty("codError")
    private Integer codError;
    @JsonProperty("msgError")
    private String msgError;
    @JsonProperty("client")
    private Client client;
    @JsonProperty("movements")
    private List<Movement> movements = null;

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

    @JsonProperty("client")
    public Client getClient() {
        return client;
    }

    @JsonProperty("client")
    public void setClient(Client client) {
        this.client = client;
    }

    @JsonProperty("movements")
    public List<Movement> getMovements() {
        return movements;
    }

    @JsonProperty("movements")
    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

}
