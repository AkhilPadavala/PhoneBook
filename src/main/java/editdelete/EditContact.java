package editdelete;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class EditContact extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String id=req.getParameter("id");
	String sql="SELECT * FROM phonebook WHERE id="+id;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phone_book","root","root");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery(sql);
		rs.next();
		PrintWriter pw=resp.getWriter();
		pw.write("<html><body>");
		pw.write("<form action=update>");
		pw.write("ID     : <input type=text name=id value="+rs.getInt(1)+" readonly><br>");
		pw.write("NAME   : <input type=text name=name value='"+rs.getString(2)+"'><br>");
		pw.write("PHONE  : <input type=text name=phone value="+rs.getLong(3)+"><br>");
		pw.write("EMAIL  : <input type=text name=email value='"+rs.getString(4)+"'><br>");
		pw.write("<input type=submit value=update>");
		pw.write("</form></body></html>");
		
		con.close();
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
	
	}
}
