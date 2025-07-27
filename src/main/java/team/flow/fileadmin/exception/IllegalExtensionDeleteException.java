package team.flow.fileadmin.exception;

import org.springframework.http.HttpStatus;

public class IllegalExtensionDeleteException extends BaseException {
    public IllegalExtensionDeleteException() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, ErrorCode.ILLEGAL_EXTENSION_DELETE);
    }
}
