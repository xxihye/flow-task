package team.flow.fileadmin.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import team.flow.fileadmin.domain.FileExtension;
import team.flow.fileadmin.domain.enums.FileExtensionType;

import java.util.List;

@Mapper
public interface FileExtensionMapper {

    @Select("SELECT * FROM file_extension")
    List<FileExtension> findAll();

    @Select("SELECT * FROM file_extension WHERE id = #{id}")
    FileExtension findById(Long id);

    @Select("SELECT * FROM file_extension WHERE extension = #{extension}")
    FileExtension findByExtension(String extension);

    @Insert("""
        INSERT INTO file_extension (extension, is_used, type)
        VALUES (#{extension}, #{isUsed}, #{type})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(FileExtension fileExtension);

    @Update(" UPDATE file_extension SET is_used = #{isUsed} WHERE id = #{id}")
    int updateIsUsedById(@Param("id") Long id, @Param("isUsed") Boolean isUsed);

    @Delete("DELETE FROM file_extension WHERE id = #{id}")
    int deleteById(Long id);

    @Select("SELECT COUNT(*) FROM file_extension WHERE is_used = #{isUsed} AND type = #{type}")
    int countExtensions(@Param("isUsed") boolean isUsed, @Param("type") FileExtensionType type);
}
