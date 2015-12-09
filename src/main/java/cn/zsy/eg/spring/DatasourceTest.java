package cn.zsy.eg.spring;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.*;

public class DatasourceTest {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("datasorce-bean.xml");
        DataSource dataSource = context.getBean("comboPooledDataSource", ComboPooledDataSource.class);
        System.out.println("########> " + dataSource.getConnection());
        Connection con = dataSource.getConnection();
        String sql = "SELECT * from user";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        String name = null;
        String pass = null;
        while (rs.next()) {
            name = rs.getString("name");
            pass = rs.getString("passwd"); // 此方法比较高效
            System.out.println(name + "   " + pass);
        }
        if (rs != null) {   // 关闭记录集
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {   // 关闭声明
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {  // 关闭连接对象
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
