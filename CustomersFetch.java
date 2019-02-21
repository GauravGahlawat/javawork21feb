import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomersFetch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/classicmodels", "root", "gaurav1997TISHA");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customers where city='NYC'");
			while(rs.next())
				//System.out.println(rs);
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			con.close(); // close the connection
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
