package Servlet_jdbc_person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginPerson extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		PersonCRUD crud = new PersonCRUD();
		String dbPassword = null;
		try {
			dbPassword = crud.LoginPerson(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PrintWriter printWriter = res.getWriter();
		if (password.equals(dbPassword)) {
			printWriter.print("Login successfully");

		} else {
			printWriter.print("Login Failed");
		}

	}

}
