import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/*
 * 工具类
 */
public final class dbcp {
    /**
     * 连接池类对象
     */
    private static DataSource dataSource;
    private dbcp() {
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


        Connection conn =  getConnect();
        String name="Andy";
        String sql="select * from worker where name=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, name);
        System.out.println("sql:");
        System.out.println("select * from worker where name=Andy");
        ResultSet rs = statement.executeQuery();
        System.out.println("result:");
        while (rs.next()) {
            System.out.println(rs.getString("name") + " "
                    + rs.getString("id")+" "+rs.getString("age")+" "
                    +rs.getString("salary")+" "+rs.getString("dep_id")
            );
        }
        rs.close();
        statement.close();

        System.out.println("---------------------------------------------------------------------");
        sql="select * from worker";
        statement = conn.prepareStatement(sql);
        System.out.println("sql:");
        System.out.println("select * from worker");
        rs = statement.executeQuery();
        System.out.println("result:");
        while (rs.next()) {
            System.out.println(rs.getString("name") + " "
                    + rs.getString("id")+" "+rs.getString("age")+" "
                    +rs.getString("salary")+" "+rs.getString("dep_id")
            );
        }
        rs.close();
        statement.close();
        System.out.println("---------------------------------------------------------------------");


        sql="insert into worker (`name`,`id`,`age`,`salary`,`dep_id`) values ('charly',171800014,23,11000,10001)";

        statement = conn.prepareStatement(sql);
        System.out.println("sql:");
        System.out.println("insert into worker (`name`,`id`,`age`,`salary`,`dep_id`) values ('charly',171800014,23,11000,10001)");
        statement.executeUpdate();
        statement.close();



        sql="select * from worker ";

        statement = conn.prepareStatement(sql);
        System.out.println("select * from worker ");
        rs = statement.executeQuery();

        System.out.println("result:");
        while (rs.next()) {
            System.out.println(rs.getString("name") + " "
                    + rs.getString("id")+" "+rs.getString("age")+" "
                    +rs.getString("salary")+" "+rs.getString("dep_id")
            );
        }
        rs.close();
        statement.close();
        System.out.println("---------------------------------------------------------------------");

        sql="update worker set name='raddy' where id=171800014";

        statement = conn.prepareStatement(sql);
        System.out.println("sql:");
        System.out.println("update worker set name='raddy' where id=171800014");
        statement.executeUpdate();
        statement.close();




        sql="select * from worker ";

        statement = conn.prepareStatement(sql);
        System.out.println("select * from worker ");
        rs = statement.executeQuery();

        System.out.println("result:");
        while (rs.next()) {
            System.out.println(rs.getString("name") + " "
                    + rs.getString("id")+" "+rs.getString("age")+" "
                    +rs.getString("salary")+" "+rs.getString("dep_id")
            );
        }
        rs.close();
        statement.close();
        System.out.println("---------------------------------------------------------------------");
        sql="delete from worker where id=171800014";

        statement = conn.prepareStatement(sql);
        System.out.println("sql:");
        System.out.println("delete from worker where id=171800014");
        statement.executeUpdate();
        statement.close();


        sql="select * from worker ";

        statement = conn.prepareStatement(sql);
        System.out.println("select * from worker ");
        rs = statement.executeQuery();

        System.out.println("result:");
        while (rs.next()) {
            System.out.println(rs.getString("name") + " "
                    + rs.getString("id")+" "+rs.getString("age")+" "
                    +rs.getString("salary")+" "+rs.getString("dep_id")
            );
        }
        rs.close();
        statement.close();
        System.out.println("---------------------------------------------------------------------");
        // 关闭资源
        conn.close();



    }

}

