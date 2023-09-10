package Servlet_jdbc_person;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DeletePerson extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		Person person = new Person();
		person.setId(id);

		PersonCRUD crud= new PersonCRUD();
		try {
			crud.deletePerson(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter printWriter = res.getWriter();
		printWriter.print("Deleted Successfully");

	}

	

}
