package in.pentagon.studentapp.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Connector {
	public static Connection requestConnection()
	{
		Connection con=null;
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3307/student","root","tiger");
		}
		catch(SQLException | ClassNotFoundException  e)
		{
			e.printStackTrace();
		}
		return con;
		
	}

}
