package cn.zsy.eg.spring;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DatasourceTest {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("datasorce-bean.xml");
        DataSource dataSource = context.getBean("comboPooledDataSource", ComboPooledDataSource.class);
        System.out.println("########> " + dataSource.getConnection());
    }
}
