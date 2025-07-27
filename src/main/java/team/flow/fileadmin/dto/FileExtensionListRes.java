package team.flow.fileadmin.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class FileExtensionListRes {

    private final List<FileExtensionRes> fixedExtensions;

    private final List<FileExtensionRes> customExtensions;

    public static FileExtensionListRes of(List<FileExtensionRes> fixedExtensions, List<FileExtensionRes> customExtensions) {
        return new FileExtensionListRes(fixedExtensions, customExtensions);
    }
}
