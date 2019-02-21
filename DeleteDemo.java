import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Connection con;
		Statement stmt;
		ResultSet rs;
		int cnt = 0;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/classicmodels","root","gaurav1997TISHA");
			
			String str = "delete from offices where city='Noida'";
			
			stmt = con.createStatement();
			
			int rowcount = stmt.executeUpdate(str);
			if(rowcount>0)
			{
				System.out.println("Record Deleted Successfully");
			}
			
			String str1 = "select count(officeCode) from offices";
			
			rs = stmt.executeQuery(str1);
			
			while(rs.next()) 
			{
				cnt = rs.getInt(1);
			}
			System.out.println("Total No. Of Records Is : " + cnt);
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
