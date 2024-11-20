import java.sql.Connection;
import java.sql.PreparedStatement;
public class UpdateBdata {
	public void updatei(int id,String col_name,int ivalue)throws Exception {
		String query="update books set "+col_name+" = ? where  BookID=? ";
		try {
			Connection con=Dbconnect.getConnection();
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,ivalue);
			pst.setInt(2, id);
			pst.executeUpdate();
			con.close();
			System.out.println("updated sucessfully");
		} catch (Exception e) {
			 System.out.println("Error while updating book: " + e.getMessage());
		}
	}
	public void updates(int id,String col_name,String svalue)throws Exception {
		String query="update books set "+col_name+" = ? where  BookID=? ";
		try {
			Connection con=Dbconnect.getConnection();
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, svalue);
			pst.setInt(2, id);
			pst.executeUpdate();
			con.close();
			System.out.println("updated sucessfully");
		} catch (Exception e) {
			 System.out.println("Error while updating book: " + e.getMessage());
		}
	}
}
