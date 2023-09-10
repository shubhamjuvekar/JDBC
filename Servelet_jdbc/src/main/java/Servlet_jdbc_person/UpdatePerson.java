package Servlet_jdbc_person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/update")
public class UpdatePerson extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long phone = Long.parseLong(req.getParameter("phone"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Person person = new Person();
		person.setId(id);
		person.setName(name);
		person.setPhone(phone);
		person.setEmail(email);
		person.setPassword(password);

		PersonCRUD crud = new PersonCRUD();
		try {
			crud.updatePerson(person);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PrintWriter printWriter = res.getWriter();
		printWriter.print("Update Sucessfully");

	}

}
