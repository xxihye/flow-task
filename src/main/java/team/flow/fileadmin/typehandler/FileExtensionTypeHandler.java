package team.flow.fileadmin.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import team.flow.fileadmin.domain.enums.FileExtensionType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(FileExtensionType.class)
public class FileExtensionTypeHandler extends BaseTypeHandler<FileExtensionType> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, FileExtensionType parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.name());
    }

    @Override
    public FileExtensionType getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return value != null ? FileExtensionType.valueOf(value) : null;
    }

    @Override
    public FileExtensionType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return value != null ? FileExtensionType.valueOf(value) : null;
    }

    @Override
    public FileExtensionType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return value != null ? FileExtensionType.valueOf(value) : null;
    }
}
