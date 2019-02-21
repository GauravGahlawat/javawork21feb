import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class ScrollableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/classicmodels", "root", "gaurav1997TISHA");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.TYPE_SCROLL_SENSITIVE);
			ResultSet rs = stmt.executeQuery("select * from customers");
			
			// reading from bottom to top
				rs.afterLast();
				
			while(rs.previous())
			{
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
			}
			
			System.out.println("********************************************************");
			
			// move cursor to 3rd Record
			
			rs.absolute(3);
			
			System.out.println(rs.getInt(1) + "  " + rs.getString(2));

			
			System.out.println("********************************************************");
			
			// move the cursor to 2nd record using relative
			
			rs.relative(-1);
			
			System.out.println(rs.getInt(1) + "  " + rs.getString(2));
			
			
			System.out.println("********************************************************");
			
			
			int i=rs.getRow();    //  get cursor position of the database 
			
				System.out.println("Cursor Poition = " + i);
				
				// clean up
				
				rs.close();
				stmt.close();
				con.close();
			
				
			con.close(); // close the connection
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
