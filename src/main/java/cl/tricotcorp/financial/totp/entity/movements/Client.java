
package cl.tricotcorp.financial.totp.entity.movements;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "enrollmentDate",
    "status",
    "timestamp",
    "statusDescription",
    "os",
    "osDescription"

})
@Generated("jsonschema2pojo")
public class Client {

    @JsonProperty("id")
    private String id;
    @JsonProperty("enrollmentDate")
    private String enrollmentDate;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("statusDescription")
    private String statusDescription;
    @JsonProperty("os")
    private String os;
    @JsonProperty("osDescription")
    private String osDescription;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("enrollmentDate")
    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    @JsonProperty("enrollmentDate")
    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("statusDescription")
    public String getStatusDescription() {
        return statusDescription;
    }

    @JsonProperty("statusDescription")
    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    @JsonProperty("os")
    public String getOs() { return os; }

    @JsonProperty("os")
    public void setOs(String os) { this.os = os; }

    @JsonProperty("osDescription")
    public String getOsDescription() { return osDescription; }

    @JsonProperty("osDescription")
    public void setOsDescription(String osDescription) { this.osDescription = osDescription; }

}
