package team.flow.fileadmin.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import team.flow.fileadmin.domain.enums.FileExtensionType;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
public class FileExtension {

    private Long id;

    private String extension;

    private FileExtensionType type;

    private boolean isUsed;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public boolean isFixed(){
        return this.type == FileExtensionType.FIXED;
    }

    public boolean isCustom(){
        return this.type == FileExtensionType.CUSTOM;
    }

    public void updateUsage(boolean isUsed) {
        this.isUsed = isUsed;
    }
}
