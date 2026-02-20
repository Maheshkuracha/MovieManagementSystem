package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import moviemanagement.DBConnection;

public class UserDaoImplementation implements UserDAO {

    @Override
    public void registerUser(String username, String password) {

        String sql = "INSERT INTO users(username, password) VALUES (?, ?)";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, username);
            ps.setString(2, password);

            ps.executeUpdate();

            System.out.println("User Registered Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean loginUser(String username, String password) {

        String sql = "SELECT * FROM users WHERE username=? AND password=?";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}