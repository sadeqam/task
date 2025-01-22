package ir.sayahi.task.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class NoMatchFoundException extends ResponseStatusException {

    public NoMatchFoundException(){
        super(HttpStatus.CONFLICT);
    }

    public NoMatchFoundException(String reason){
        super(HttpStatus.CONFLICT, reason);
    }

    public NoMatchFoundException(HttpStatusCode status) {
        super(status);
    }

    public NoMatchFoundException(HttpStatusCode status, String reason) {
        super(status, reason);
    }

    public NoMatchFoundException(int rawStatusCode, String reason, Throwable cause) {
        super(rawStatusCode, reason, cause);
    }

    public NoMatchFoundException(HttpStatusCode status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

    protected NoMatchFoundException(HttpStatusCode status, String reason, Throwable cause, String messageDetailCode, Object[] messageDetailArguments) {
        super(status, reason, cause, messageDetailCode, messageDetailArguments);
    }
}
