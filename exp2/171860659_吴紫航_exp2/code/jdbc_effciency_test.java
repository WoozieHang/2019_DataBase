import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class jdbc_effciency_test {
    public static void conn() {
        String URL = "jdbc:mysql://localhost:3306/exp2?serverTimezone=UTC&characterEncoding=utf8&useSSL=false&useUnicode=true";
        String USER = "root";
        String PASSWORD = "991204";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            long start = System.currentTimeMillis( );
            for (int i = 0; i < 2000; i++) {
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
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

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        conn();
    }

};