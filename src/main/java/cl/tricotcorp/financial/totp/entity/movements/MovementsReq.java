
package cl.tricotcorp.financial.totp.entity.movements;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
        "dateFrom",
        "dateUntil",
        "status"
})
@Generated("jsonschema2pojo")
public class MovementsReq {

    @JsonProperty("id")
    private String id;

    @JsonProperty("dateFrom")
    private String dateFrom;

    @JsonProperty("dateUntil")
    private String dateUntil;

    @JsonProperty("status")
    private String status;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("dateFrom")
    public String getDateFrom() {
        return dateFrom;
    }

    @JsonProperty("dateFrom")
    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    @JsonProperty("dateUntil")
    public String getDateUntil() {
        return dateUntil;
    }

    @JsonProperty("dateUntil")
    public void setDateUntil(String dateUntil) {
        this.dateUntil = dateUntil;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }
}
