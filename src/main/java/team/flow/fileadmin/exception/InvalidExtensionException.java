package team.flow.fileadmin.exception;

import org.springframework.http.HttpStatus;

public class InvalidExtensionException extends BaseException{
    public InvalidExtensionException(ErrorCode errorCode) {
        super(HttpStatus.BAD_REQUEST, errorCode);
    }
}
