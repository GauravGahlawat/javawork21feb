import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		int cnt = 0;
		String sqlUpdate;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/classicmodels","root","gaurav1997TISHA");
			
			sqlUpdate = "UPDATE employees " + "SET jobTitle = ? " + "WHERE employeeNumber = ?";
			
			pstmt = con.prepareStatement(sqlUpdate);
			
			// prepared data for Update
			
			Scanner s = new Scanner(System.in);
			
			System.out.println("Enter Employee Id :");
			
			int eid = s.nextInt(); // 1702
			 s.nextLine();

			System.out.println("Enter New Job Title :");
			
			String strm = s.nextLine(); // Sales Manager
			
			pstmt.setString(1,strm);
			pstmt.setInt(2,eid);
			
			int rowAffected = pstmt.executeUpdate();
			System.out.println("Row Affected :" + rowAffected);

			// reuse the prepared statement
			
			strm = "Sales Head";
			eid = 1370;
			
			pstmt.setString(1, strm);
			pstmt.setInt(2, eid);;
			
			rowAffected = pstmt.executeUpdate();
			

			System.out.println("Row Affected :" + rowAffected);
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}

}
