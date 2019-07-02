package dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import data.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpDAO {
    public static Connection getConnection() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        String url = "jdbc:mysql://127.0.0.1:3306/word_counter_app";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            dataSource.setUrl(url);
            dataSource.setUser("root");
            dataSource.setPassword("");
//            DriverManager.getConnection(url, "root", "");
        } catch (Exception e){
            e.printStackTrace();
        }

        return dataSource.getConnection();
    }

    public static int saveUser(User user){
        int status = 0;
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (nickname, password) VALUES (?,?)");

            preparedStatement.setString(1, user.getNickname());
            preparedStatement.setString(2, user.getPassword());

            status = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return status;
    }
}
