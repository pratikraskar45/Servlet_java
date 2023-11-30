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
@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id=Integer.parseInt(req.getParameter("id"));
		
		Studentdao studentdao=new Studentdao();
		boolean b= studentdao.deletestudent(id);
		
		if (b) {
			List<Student> list=studentdao.getallStudent();
			req.setAttribute("list", list);
			RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
			
		}else {
			System.out.println("id not found");
		}
	}

}
