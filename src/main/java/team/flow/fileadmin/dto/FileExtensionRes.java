package team.flow.fileadmin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import team.flow.fileadmin.domain.FileExtension;

@Getter
@Builder
public class FileExtensionRes {
    @Schema(description = "확장자 id")
    private Long id;

    @Schema(description = "확장자명")
    private String extension;

    @Schema(description = "확장자 타입", example = "FIXED, CUSTOM")
    private String type;

    @JsonProperty("isUsed")
    @Schema(description = "사용 여부")
    private boolean isUsed;

    public static FileExtensionRes from(FileExtension fileExtension) {
        return FileExtensionRes.builder()
                               .id(fileExtension.getId())
                               .extension(fileExtension.getExtension())
                               .type(fileExtension.getType().name())
                               .isUsed(fileExtension.isUsed())
                               .build();
    }
}
