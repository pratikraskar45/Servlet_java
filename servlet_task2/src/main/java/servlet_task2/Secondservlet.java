package servlet_task2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Secondservlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		
		PrintWriter printWriter=res.getWriter();  //PrintWriter is a print in browser // req is from client
		printWriter.print("Second servlet got hitted");
		
	}
	

}
