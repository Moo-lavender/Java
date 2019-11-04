
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;
public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/selected";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "hj.1009";
    private static MysqlDataSource DATASOURCE = new MysqlDataSource();
    static {
        DATASOURCE.setURL(URL);
        DATASOURCE.setUser(USER_NAME);
        DATASOURCE.setPassword(PASSWORD);
    }

    /**
     * 封装一个返回值为connection的方法，来获取数据库的连接
     * 1.Class.forNAme("com.mysql.jdbc.Driver")
     * Driver
     * 2.DataSource
     */
    static Connection getConnection(){

        try {
            return DATASOURCE.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("获取数据库连接失败");
        }
    }
    /**
     * 释放数据库
     * @param  connection
     * @param ps 数据库操作对象
     * @param rs 结果集
     */

    public static void close(Connection connection,PreparedStatement ps, ResultSet rs){
        try{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(connection != null){
                connection.close();
            }
        }catch (SQLException e){
            throw new RuntimeException("释放数据库资源错误");
        }
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }

}
