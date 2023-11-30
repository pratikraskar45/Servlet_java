package student_managment_system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_managment_system.dao.Studentdao;
import student_managment_system.dto.Student;
@WebServlet("/edit")
public class StudentEditController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Student student=new Student();
		student.setId(id);
		student.setName(name);
		student.setEmail(email);
		student.setAddress(address);
		student.setPassword(password);
		
		Studentdao studentdao=new Studentdao();
		Student student2= studentdao.updateStudent(student);
		if (student2!=null) {
			List<Student> list= studentdao.getallStudent();
		   req.setAttribute("list", list);
		   RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
		   dispatcher.forward(req, resp);
		}else {
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
	}
	

}
