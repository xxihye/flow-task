package team.flow.fileadmin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import team.flow.fileadmin.domain.FileExtension;
import team.flow.fileadmin.domain.enums.FileExtensionType;
import team.flow.fileadmin.dto.CustomExtensionReq;
import team.flow.fileadmin.dto.ExtensionUpdateReq;
import team.flow.fileadmin.dto.FileExtensionListRes;
import team.flow.fileadmin.dto.FileExtensionRes;
import team.flow.fileadmin.exception.DuplicateExtensionException;
import team.flow.fileadmin.exception.ExtensionNotFoundException;
import team.flow.fileadmin.exception.IllegalExtensionDeleteException;
import team.flow.fileadmin.exception.IllegalExtensionUpdateException;
import team.flow.fileadmin.mapper.FileExtensionMapper;
import team.flow.fileadmin.exception.ExtensionLimitExceededException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileExtensionService {

    private final FileExtensionMapper extensionMapper;

    public FileExtensionListRes getActiveExtensions() {
        //전체 확장자 리스트 조회
        List<FileExtension> extensions = extensionMapper.findAll();

        //고정 확장자 리스트
        List<FileExtensionRes> fixedExtensions = extensions.stream()
                                                           .filter(FileExtension::isFixed)
                                                           .map(FileExtensionRes::from)
                                                           .collect(Collectors.toList());

        //커스텀 확장자 리스트
        List<FileExtensionRes> customExtensions = extensions.stream()
                                                            .filter(FileExtension::isCustom)
                                                            .map(FileExtensionRes::from)
                                                            .collect(Collectors.toList());

        return FileExtensionListRes.of(fixedExtensions, customExtensions);
    }

    //커스텀 확장자 등록
    public FileExtensionRes registerCustomExtension(CustomExtensionReq req) {
        int count = extensionMapper.countExtensions(true, FileExtensionType.CUSTOM);

        //커스텀 확장자 등로 최대 개수 제한
        if(count == 200){
            throw new ExtensionLimitExceededException();
        }

        String extension = req.getExtension().toLowerCase();
        FileExtension fileExtension = extensionMapper.findByExtension(extension);

        if (fileExtension != null) {
            // 이미 존재하는 확장자 처리
            if (fileExtension.isUsed()) {
                throw new DuplicateExtensionException();
            }

            fileExtension.updateUsage(true);
            extensionMapper.updateIsUsedById(fileExtension.getId(), fileExtension.isUsed());
        } else {
            //없는 경우 새로 생성 후 저장
            fileExtension = FileExtension.builder()
                                                .extension(extension)
                                                .type(FileExtensionType.CUSTOM)
                                                .isUsed(true)
                                                .build();

            extensionMapper.save(fileExtension);
        }

        return FileExtensionRes.from(fileExtension);
    }

    //고정 확장자 사용여부 수정
    public void updateFixedExtension(ExtensionUpdateReq req) {
        FileExtension extension = extensionMapper.findById(req.getId());

        //확장자 조회 실패시 예외처리
        if(extension == null){
            throw new ExtensionNotFoundException();
        }

        //커스텀 확장자 수정 시도시 예외처리
        if (extension.getType() == FileExtensionType.CUSTOM) {
            throw new IllegalExtensionUpdateException();
        }

        //사용여부 수정
        extensionMapper.updateIsUsedById(extension.getId(), req.getIsUsed());
    }

    //커스텀 확장자 삭제
    public void deleteCustomExtension(Long id) {
        FileExtension extension = extensionMapper.findById(id);

        //조회 실패시 예외처리
        if(extension == null){
            throw new ExtensionNotFoundException();
        }

        //고정 확장자 삭제 시도시 예외처리
        if (extension.getType() == FileExtensionType.FIXED) {
            throw new IllegalExtensionDeleteException();
        }

        //확장자 삭제
        extensionMapper.deleteById(id);
    }
}
