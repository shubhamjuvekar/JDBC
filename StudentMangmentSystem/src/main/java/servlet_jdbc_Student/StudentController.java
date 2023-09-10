package servlet_jdbc_Student;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String s_name=req.getParameter("s_name");
		String f_name=req.getParameter("f_name");
		String m_name=req.getParameter("m_name");
		int age=Integer.parseInt(req.getParameter("age"));
		long phone=Long.parseLong(req.getParameter("phone"));
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		ServletContext context=getServletContext();
		String school=context.getInitParameter("school");
		
		Student student=new Student();
		student.setId(id);
		student.setS_name(s_name);
		student.setF_name(f_name);
		student.setM_name(m_name);
		student.setAge(age);
		student.setPhone(phone);
		student.setEmail(email);
		student.setPassword(password);
		student.setSchool(school);
		
		
		
		String fee=req.getParameter("fees");
		if(fee.equals("oneshot"))
		{
			ServletConfig config=getServletConfig();
			long fees=Long.parseLong(config.getInitParameter("OneShot"));
			
			student.setFees(fees);
		}
		else
		{
			ServletConfig config=getServletConfig();
			long fees=Long.parseLong(config.getInitParameter("Installment"));
			
			student.setFees(fees);
		}
		
		StudentCRUD crud=new StudentCRUD();
		try {
			int count=crud.saveStudent(student);
			if(count!=0)
			{
				RequestDispatcher rd= req.getRequestDispatcher("home.html");
				rd.forward(req, resp);
			}
			else
			{
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
				rd.forward(req, resp);
			}
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
