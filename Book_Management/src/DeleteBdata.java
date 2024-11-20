import java.sql.*;
public class DeleteBdata {
	public void delete(int id)throws Exception {
		String query="delete from books where id=?";
		try {
			Connection con=Dbconnect.getConnection();
			PreparedStatement pst=con.prepareStatement(query);
			
			pst.setInt(1, id);
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			 System.out.println("Error deleting book: " + e.getMessage());
		}
	}
}
