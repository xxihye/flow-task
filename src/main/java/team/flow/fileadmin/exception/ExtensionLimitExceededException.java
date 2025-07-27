package team.flow.fileadmin.exception;

import org.springframework.http.HttpStatus;
import team.flow.fileadmin.exception.BaseException;
import team.flow.fileadmin.exception.ErrorCode;

public class ExtensionLimitExceededException extends BaseException {
    public ExtensionLimitExceededException() {
        super(HttpStatus.CONFLICT, ErrorCode.EXCEED_EXTENSION_LIMIT);
    }
}
