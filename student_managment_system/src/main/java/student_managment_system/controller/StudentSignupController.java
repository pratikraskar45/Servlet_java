package student_managment_system.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_managment_system.dao.Studentdao;
import student_managment_system.dto.Student;
@WebServlet("/signup")
public class StudentSignupController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=getInitParameter("name");
		String address=getInitParameter("address");
		String email=getInitParameter("email");
		String password=getInitParameter("password");
		
		Student student=new Student();
		student.setName(name);
		student.setAddress(address);
		student.setEmail(email);
		student.setPassword(password);
		
		Studentdao studentdao=new Studentdao();
		Student student2= studentdao.savestudent(student);
		if (student!=null) {
			req.setAttribute("message", "signedup sccessfully");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
			
		}
		
	}
	
	
}
