package DAO;

import JDBCUtils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDAO<T> {
    private QueryRunner qr = new QueryRunner();

    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) throws SQLException {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            return qr.query(connection, sql, new BeanListHandler<T>(clazz),parameters);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        } finally {
            JDBCUtils.close(null, null, connection);
        }
    }
}
