import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 工具类
 */
public final class dbcp_effciency_test {
    /**
     * 连接池类对象
     */
    private static DataSource dataSource;
    private dbcp_effciency_test() {
    }

    public static Connection getConnect() throws SQLException {
        return dataSource.getConnection();
    }

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 利用Properties集合加载数据源
            Properties prop = new Properties();
            InputStream is = dbcp.class.getClassLoader()
                    .getResourceAsStream("dbcpconfig.properties");
            prop.load(is);
            // 利用工厂模式创建数据库
            dataSource = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }

        long start = System.currentTimeMillis( );
        for (int i = 0; i < 2000; i++) {
            Connection conn = getConnect();
            String name="Andy";
            String sql="select * from worker where name=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            rs.close();
            statement.close();
            conn.close();
        }

        long end = System.currentTimeMillis( );//获取结束时间
        long interval = (end - start);//转换为秒数
        System.out.println("时间间隔 : " + interval+"毫秒");



    }

}

