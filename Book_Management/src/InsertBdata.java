import java.sql.*;
import java.util.Scanner;

public class InsertBdata {

    public void insert(int book_id, String book_title, String author_name, long isbn, String category,
                              String publisher, Date publication_date, int book_sprice, int book_cprice, 
                              int book_stock, String book_language, String book_version, int book_pages, 
                              String book_format, String book_description, String book_coverimage) throws Exception {
        
        
        String query = "INSERT INTO books VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

       try {
    	Connection con = Dbconnect.getConnection();
        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, book_id);
        pst.setString(2, book_title);
        pst.setString(3, author_name);
        pst.setLong(4, isbn);
        pst.setString(5, category);
        pst.setString(6, publisher);
        pst.setDate(7, publication_date);
        pst.setInt(8, book_sprice);
        pst.setInt(9, book_cprice);
        pst.setInt(10, book_stock);
        pst.setString(11, book_language);
        pst.setString(12, book_version);
        pst.setInt(13, book_pages);
        pst.setString(14, book_format);
        pst.setString(15, book_description);
        pst.setString(16, book_coverimage);

        pst.executeUpdate();
        con.close();
        System.out.println("Data inserted successfully.");
        }catch (SQLException e) {
            System.out.println("Error executing SQL for Venue table: " + e.getMessage());
            e.printStackTrace();
            }
    }
}
