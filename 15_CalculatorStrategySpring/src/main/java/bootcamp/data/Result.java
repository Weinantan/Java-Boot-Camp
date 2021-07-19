package bootcamp.data;

import java.math.BigDecimal;
import java.util.Optional;

public class Result {
    private final Status status ;
    private final String statusMessage ;
    private final Optional<BigDecimal> value ;

    //TODO Constructor. If there was an error in processing, set the relevant status, message and value to empty Optional.
    //TODO Getters

    public Result(Status status, String statusMessage, Optional<BigDecimal> value) {
        this.status = status;
        this.statusMessage = statusMessage;
        this.value = value;
    }

    public Status getStatus() {
        return status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public Optional<BigDecimal> getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", statusMessage='" + statusMessage + '\'' +
                ", value=" + value +
                '}';
    }
}
