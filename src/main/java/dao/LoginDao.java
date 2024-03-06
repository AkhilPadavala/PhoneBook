package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao 
{
    public static boolean validateLogin(String email, String password)
	{
		String sql="SELECT * FROM signin WHERE email='"+email+"' AND password='"+password+"'";		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phone_book","root","root");
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery(sql);
			if(rs.next())
			{
				con.close();
				return true;
			}			
		}
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}	
}


