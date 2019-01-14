package mvc.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.model.Student;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/jspfiles/create.jsp").forward(req,resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		String className = req.getParameter("className");
		
		Student student = new Student(name,className);
		
		session.setAttribute("myStudent", student);
		
		req.getRequestDispatcher("/WEB-INF/jspfiles/showstudent.jsp").forward(req, resp);
		
	}
}
