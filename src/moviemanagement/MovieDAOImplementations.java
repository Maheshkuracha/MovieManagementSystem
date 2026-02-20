package moviemanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MovieDAOImplementations implements MovieDAO {

    @Override
    public void addMovie(Movie m) {

        String sql = "INSERT INTO movies (name, genre, rating) VALUES (?, ?, ?)";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setString(1, m.getName());
            ps.setString(2, m.getGenre());
            ps.setDouble(3, m.getRating());

            ps.executeUpdate();

            System.out.println("Movie Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewMovies(int pageNumber, int pageSize) {

        String sql = "SELECT * FROM movies LIMIT ? OFFSET ?";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {

            int offset = (pageNumber - 1) * pageSize;

            ps.setInt(1, pageSize);
            ps.setInt(2, offset);

            try (ResultSet rs = ps.executeQuery()) {

                System.out.println("ID | NAME | GENRE | RATING");
                System.out.println("-----------------------------");

                while (rs.next()) {

                    System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("genre") + " | " +
                        rs.getDouble("rating")
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchMovieByName(String name) {

        String sql = "SELECT * FROM movies WHERE name=?";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setString(1, name);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    System.out.println(
                        "ID: " + rs.getInt("id") + " | " +
                        "Name: " + rs.getString("name") + " | " +
                        "Genre: " + rs.getString("genre") + " | " +
                        "Rating: " + rs.getDouble("rating")
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRating(int id, double rating) {

        String sql = "UPDATE movies SET rating=? WHERE id=?";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setDouble(1, rating);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Rating Updated Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sortByRating() {

        String sql = "SELECT * FROM movies ORDER BY rating DESC";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {

                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("genre") + " | " +
                    rs.getDouble("rating")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sortByName() {

        String sql = "SELECT * FROM movies ORDER BY name ASC";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {

                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("genre") + " | " +
                    rs.getDouble("rating")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void filterByGenre(String genre) {

        String sql = "SELECT * FROM movies WHERE genre=?";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setString(1, genre);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("genre") + " | " +
                        rs.getDouble("rating")
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void filterByRating(double rating) {

        String sql = "SELECT * FROM movies WHERE rating > ?";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setDouble(1, rating);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("genre") + " | " +
                        rs.getDouble("rating")
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMovie(int id) {

        String sql = "DELETE FROM movies WHERE id=?";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Movie Deleted Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}