package team.flow.fileadmin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ExtensionUpdateReq {

    @Schema(description = "확장자 ID")
    @NotNull(message = "ID는 필수입니다.")
    private Long id;

    @Schema(description = "활성화 여부")
    @NotNull(message = "활성화 여부는 필수입니다.")
    @JsonProperty("isUsed")
    private Boolean isUsed;
}
