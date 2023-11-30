package student_managment_system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student_managment_system.dao.Studentdao;
import student_managment_system.dto.Student;
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Studentdao studentdao=new Studentdao();
		Student student= studentdao.loginstudent(email);
		if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
			List<Student> list=studentdao.getallStudent();
			req.setAttribute("list", list);
			//3-
//			HttpSession httpSession=req.getSession();
//			httpSession.setAttribute("username", student.getName());
//			RequestDispatcher dispatcher=req.getRequestDispatcher("display");
//			dispatcher.forward(req, resp);
			
			
			//2-
			Cookie cookie=new Cookie("username", student.getName());
			resp.addCookie(cookie);
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("display");
			dispatcher.forward(req, resp);
			//1-
//			RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
//			dispatcher.forward(req, resp);
		
		}else {
			req.setAttribute("message", "Please login with proper credentials");
			RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
			dispatcher.include(req, resp);
		}
	}

}
