package team.flow.fileadmin.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    EXCEED_EXTENSION_LIMIT("확장자 등록 제한을 초과하였습니다."),
    ILLEGAL_EXTENSION_DELETE("고정 확장자는 삭제할 수 없습니다."),
    ILLEGAL_EXTENSION_UPDATE("커스텀 확장자는 수정할 수 없습니다"),
    EXTENSION_NOT_FOUND("존재하지 않는 확장자입니다."),
    INTERNAL_SERVER_ERROR("서버 내부 오류입니다."),
    DUPLICATE_EXTENSION("이미 존재하는 확장자입니다.");

    private final String message;
}
