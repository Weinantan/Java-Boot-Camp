package bootcamp.data;

import java.util.Optional;

public class Result<T> {
    private final Status status ;
    private final String statusMessage ;
    private final Optional<T> value ;

    public Result(Status status, String statusMessage, Optional<T> value) {
        this.status = status;
        this.statusMessage = statusMessage;
        this.value = value;
    }

    //Indication success
    public Result(Optional<T> value) {
        this.value = value;
        this.status = Status.SUCCESS;
        this.statusMessage ="";
    }

    //Indicating error
    public Result(Status status) {
        this.status = status;
        this.statusMessage = "No such an record found";
        this.value = Optional.empty();
    }

    public Status getStatus() {
        return status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public Optional<T> getValue() {
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
//TODO Constructor. If there was an error in processing, set the relevant status, message and value to empty Optional.
    //TODO Getters
}
