package team.flow.fileadmin.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.flow.fileadmin.dto.CustomExtensionReq;
import team.flow.fileadmin.dto.ExtensionUpdateReq;
import team.flow.fileadmin.dto.FileExtensionListRes;
import team.flow.fileadmin.dto.FileExtensionRes;
import team.flow.fileadmin.service.FileExtensionService;

@RestController
@RequestMapping("/api/extensions")
@RequiredArgsConstructor
public class FileExtController {

    private final FileExtensionService fileExtensionService;

    @GetMapping
    @Operation(description = "전체 확장자 조회")
    public ResponseEntity<FileExtensionListRes> getActiveExtensions() {
        return ResponseEntity.ok(fileExtensionService.getActiveExtensions());
    }

    @PatchMapping("/fixed")
    @Operation(description = "고정 확장자 수정")
    public ResponseEntity<Void> updateFixedExtension(@Valid @RequestBody ExtensionUpdateReq req) {
        fileExtensionService.updateFixedExtension(req);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/custom")
    @Operation(description = "커스텀 확장자 등록")
    public ResponseEntity<FileExtensionRes> registerCustomExtension(@Valid @RequestBody CustomExtensionReq req) {
        return ResponseEntity.ok(fileExtensionService.registerCustomExtension(req));
    }

    @DeleteMapping("/custom/{id}")
    @Operation(description = "커스텀 확장자 삭제")
    public ResponseEntity<Void> deleteCustomExtension(@PathVariable Long id) {
        fileExtensionService.deleteCustomExtension(id);
        return ResponseEntity.ok().build();
    }
}
