package team.flow.fileadmin.exception;

import org.springframework.http.HttpStatus;

public class IllegalExtensionUpdateException extends BaseException {
    public IllegalExtensionUpdateException() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, ErrorCode.ILLEGAL_EXTENSION_UPDATE);
    }
}
