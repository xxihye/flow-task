package team.flow.fileadmin.exception;

import org.springframework.http.HttpStatus;

public class DuplicateExtensionException extends BaseException {
    public DuplicateExtensionException() {
        super(HttpStatus.CONFLICT, ErrorCode.DUPLICATE_EXTENSION);
    }
}
