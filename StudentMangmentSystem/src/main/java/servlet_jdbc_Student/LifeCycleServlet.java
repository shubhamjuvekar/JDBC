package servlet_jdbc_Student;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifeCycleServlet extends GenericServlet {

	public LifeCycleServlet()
	{
		System.out.println("Instantation");
	}
	@Override
	public void init() throws ServletException {
	System.out.println("Init Excute method");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service Excute method");
		
	}
	@Override
	public void destroy() {
		System.out.println("destroy Excute method");
	}
	

}
