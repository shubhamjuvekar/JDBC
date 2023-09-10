package servlet_jdbc_Student;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		ServletContext context=getServletContext();
	String school=context.getInitParameter("school");
	
	
	StudentCRUD crud=new StudentCRUD();
	try {
		Student dbStudent=crud.getStudentInfo(email);
		if(password.equals(dbStudent.getPassword())&& school.equals(dbStudent)){
		resp.sendRedirect("success.html");
		}
		else
		{
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.html");
			requestDispatcher.forward(req, resp);
		}
	} catch (ClassNotFoundException e ) {
		
		e.printStackTrace();
	}catch (Exception e) {
		// TODO: handle exception
	}
	}

}
