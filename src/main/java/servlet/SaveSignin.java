package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SignInDao;
@WebServlet("/savesignin")
public class SaveSignin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		long phone=Long.parseLong(req.getParameter("phone"));
		String email=req.getParameter("email");
		String password1=req.getParameter("password1");
		String password2=req.getParameter("password2");

		boolean res=password1.equals(password2);
		if(res)
		{
			boolean res2=SignInDao.saveSignIn(name, phone, email, password1);
			if(res2) {
			PrintWriter pw=resp.getWriter();
			pw.write("<h1>DATA SAVED SUCCESSFULLY</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.include(req, resp);
		}
			else
			{
				PrintWriter pw=resp.getWriter();
				pw.write("<h1>SOMETHING WENT WRONG PLEASE TRY AGAIN</h1>");
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.include(req, resp);
			}
		}
		else
		{
			PrintWriter pw=resp.getWriter();
			pw.write("<h1>password and conform password not matching</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("signin.jsp");
			rd.include(req, resp);
		}
		
	}

}
