import java.util.*;
import java.sql.*;

public class GetBdata {
    
    public void getid(int id) throws Exception {
        String query = "SELECT * FROM books WHERE BookID = ?";
        try {
            Connection con = Dbconnect.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id); 
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println("Book Details:");
                System.out.println("ID: " + rs.getInt("BookID"));
                System.out.println("Title: " + rs.getString("Title"));
                System.out.println("Author: " + rs.getString("Author"));
                System.out.println("ISBN: " + rs.getString("ISBN"));
                System.out.println("Genre: " + rs.getString("Genre"));
                System.out.println("Publisher: " + rs.getString("Publisher"));
                System.out.println("Publication Date: " + rs.getDate("PublicationDate"));
                System.out.println("Selling Price: " + rs.getInt("Price"));
                System.out.println("Cost Price: " + rs.getInt("CostPrice"));
                System.out.println("Stock: " + rs.getInt("StockQuantity"));
                System.out.println("Language: " + rs.getString("Language"));
                System.out.println("Edition: " + rs.getString("Edition"));
                System.out.println("Pages: " + rs.getInt("PageCount"));
                System.out.println("Format: " + rs.getString("BookFormat"));
                System.out.println("Description: " + rs.getString("Description"));
                System.out.println("Cover Image: " + rs.getString("BookCoverImage"));
            }
        } catch (Exception e) {
            System.out.println("Error getting book with id: " + e.getMessage());
        }
    }

    public void get() throws Exception {
        String query = "SELECT * FROM books";
        try {
            Connection con = Dbconnect.getConnection();
            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(query);

            while (rs.next()) {
                System.out.println("Book Details:");
                System.out.println("ID: " + rs.getInt("BookID"));
                System.out.println("Title: " + rs.getString("Title"));
                System.out.println("Author: " + rs.getString("Author"));
                System.out.println("ISBN: " + rs.getString("ISBN"));
                System.out.println("Genre: " + rs.getString("Genre"));
                System.out.println("Publisher: " + rs.getString("Publisher"));
                System.out.println("Publication Date: " + rs.getDate("PublicationDate"));
                System.out.println("Selling Price: " + rs.getInt("Price"));
                System.out.println("Cost Price: " + rs.getInt("CostPrice"));
                System.out.println("Stock: " + rs.getInt("StockQuantity"));
                System.out.println("Language: " + rs.getString("Language"));
                System.out.println("Edition: " + rs.getString("Edition"));
                System.out.println("Pages: " + rs.getInt("PageCount"));
                System.out.println("Format: " + rs.getString("BookFormat"));
                System.out.println("Description: " + rs.getString("Description"));
                System.out.println("Cover Image: " + rs.getString("BookCoverImage"));
            }
        } catch (Exception e) {
            System.out.println("Error getting book: " + e.getMessage());
        }
    }
}
