package net.ayman.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import net.ayman.model.User;

public class UserDao {

    private static final String URL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0000";

    public User getUserByUsername(String username) {
        User user = null;
        String sql = "SELECT * FROM USER WHERE USERNAME = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // If a user with the given username is found, create a User object
                	user = new User();
                    user.setUserId(resultSet.getInt("user_id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., logging or throwing it
        }
        return user;
    }
    
    public User getUserById(int userId) {
        User user = null;
        String sql = "SELECT * FROM USER WHERE USER_ID = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // If a user with the given username is found, create a User object
                	user = new User();
                    user.setUserId(resultSet.getInt("user_id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., logging or throwing it
        }
        return user;
    }
    
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM user"; 
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                	User user = new User();
                     user.setUserId(resultSet.getInt("user_id"));
                     user.setUsername(resultSet.getString("username"));
                     user.setPassword(resultSet.getString("password"));
                    // Create a User object with the retrieved data
                    
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any SQL exceptions here
        }

        return users;
    }
    
    public boolean deleteUser(int userId) {
        String sql = "DELETE FROM user WHERE user_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            int rowsAffected = statement.executeUpdate();
            // If deletion was successful (1 row affected), return true
            return rowsAffected == 1;
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateUser(User updatedUser) {
        // SQL query to update a request in the database
        String sql = "UPDATE user SET username = ?, password = ? WHERE user_id = ?";
        
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set the parameters in the PreparedStatement
            statement.setString(1, updatedUser.getUsername());
            statement.setString(2, updatedUser.getPassword());
            statement.setInt(3, updatedUser.getUserId());
            
            // Execute the update query
            int rowsAffected = statement.executeUpdate();
             
            // If update was successful (1 row affected), return true
            return rowsAffected == 1;
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean addUser(User user) {
        String sql = "INSERT INTO user (username, password) VALUES (?, ?)";
        
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            
            int rowsAffected = statement.executeUpdate();
            
            // If one row is affected, insertion is successful
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int validateUser(String username, String password) {
        String sql = "{CALL ValidateUser(?, ?, ?)}";
        int count = 0;

        try (Connection connection = getConnection();
             CallableStatement statement = connection.prepareCall(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.registerOutParameter(3, Types.INTEGER); // Register p_valid as an output parameter
                
            statement.execute();

            count = statement.getInt(3); // Retrieve the value of p_valid from the output parameter
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public int getUserIdByUsername(String username) {
        int userId = -1;
        try (Connection connection = getConnection()) {
            String sql = "SELECT user_id FROM user WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        userId = resultSet.getInt("user_id");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }

    private Connection getConnection() throws SQLException {
        try {
            // Attempt to load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // If the driver class is not found, print an error message
            System.err.println("MySQL JDBC Driver not found. Make sure it's included in your classpath.");
            e.printStackTrace();
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
