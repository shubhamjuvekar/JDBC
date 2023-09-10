package Servlet_jdbc_person;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/save")
public class PersonController extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
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
			crud.savePerson(person);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PrintWriter printWriter = res.getWriter();
		printWriter.print("Saved Sucessfully");

	}

}
