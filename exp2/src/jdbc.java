import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class jdbc {
    public static void conn() {
        String URL = "jdbc:mysql://localhost:3306/exp2?serverTimezone=UTC&characterEncoding=utf8&useSSL=false&useUnicode=true";
        String USER = "root";
        String PASSWORD = "991204";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
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
