package com.ycit.db;

import com.ycit.beans.User;
import com.ycit.config.AppConfig;
import com.ycit.config.DataSourceConfig;
import com.ycit.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.sql.*;
import java.util.List;

/**
 * Created by xlch on 2016/12/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, DataSourceConfig.class})
public class ConnectionTest {

    @Autowired
    private UserService userService;

    @Test
    public void connect() {
        List<User> name = userService.find();
        System.out.println(name);
    }

    @Test
    public void mysqlConnection() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 可省略
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xlch?serverTimezone=UTC&useSSL=false", "root", "root");//参数分别代表 url 、userName 、password
            statement = connection.prepareStatement("select * from user where id = ?");
            statement.setInt(1, 1);//动态设置 id 为 1，index 为 1（起始为1）
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                System.out.println("id===" + set.getInt("id") + "    name===" + set.getString(2));//可以通过 index 或者 labelName 获取
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }  finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void oracleConnection() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // java　反射
            connection = DriverManager.getConnection("jdbc:oracle:thin:@10.15.100.104:1521:orcl", "perp", "perp");//参数分别代表 url 、userName 、password
            statement = connection.prepareStatement("select * from test_clob where id = ?");
            statement.setInt(1, 1);//动态设置 id 为 1，index 为 1（起始为1）
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                System.out.println("id===" + set.getInt("id") + "    name===" + set.getString(2));//可以通过 index 或者 labelName 获取
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void insertClob() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // java　反射
            connection = DriverManager.getConnection("jdbc:oracle:thin:@10.15.100.104:1521:orcl", "perp", "perp");//参数分别代表 url 、userName 、password
            statement = connection.createStatement();
            statement.executeUpdate("insert into test_html (cznrc, rksj) values (empty_clob(),'201612201045')");
            ResultSet rs = statement.executeQuery("select cznrc from test_html where rksj = '201612201045' for update");
            if (rs.next()) {
                File file = new File("D:\\about project\\perp-service\\处理文档\\new.txt");
                Clob clob = rs.getClob("cznrc");
                Reader reader = clob.getCharacterStream();
                Writer writer = clob.setCharacterStream(1);
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line = bufferedReader.readLine();
                while (line != null) {
                    writer.append(line);
                    line = bufferedReader.readLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
