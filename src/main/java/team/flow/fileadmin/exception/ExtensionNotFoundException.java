package team.flow.fileadmin.exception;

import org.springframework.http.HttpStatus;

public class ExtensionNotFoundException extends BaseException{
    public ExtensionNotFoundException() {
        super(HttpStatus.NOT_FOUND, ErrorCode.EXTENSION_NOT_FOUND);
    }
}
