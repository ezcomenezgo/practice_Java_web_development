import java.io.PrintStream;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String sql_statement = "select * from Video";
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/wilsonvideodb", "claire", "password");

        if (c != null) {
            System.out.println("database connect successfully!");
        } else {
            System.out.println("cannot connect!");
        }

        PreparedStatement pps = c.prepareStatement(sql_statement);
        ResultSet rs = pps.executeQuery();
        ArrayList<Video> result = new ArrayList<>();
        while (rs.next()) {
            Video v = new Video(
                    Integer.parseInt(rs.getString("videoId")),
                    rs.getString("videoName"),
                    Integer.parseInt(rs.getString("price"))
            );
            result.add(v);
        }

        for (Video v : result) {
            System.out.println("data: " + v.toString());
        }

        // stop connection to avoid consuming recourse
        c.close();
    }
}