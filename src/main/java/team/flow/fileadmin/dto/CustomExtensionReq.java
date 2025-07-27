package team.flow.fileadmin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CustomExtensionReq {

    @Schema(description = "확장자명")
    @NotBlank(message = "확장자명은 필수입니다.")
    @Size(min = 1, max = 20, message = "확장자명은 1자 이상 20자 이하여야 합니다.")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "확장자명은 영어 알파벳만 허용됩니다.")
    private String extension;
}
