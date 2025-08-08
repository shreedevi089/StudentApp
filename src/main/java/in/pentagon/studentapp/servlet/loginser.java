package in.pentagon.studentapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class loginser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		//resp.setContentType("text/html");
		StudentDAO sdao=new StudentDAOImpl();
		HttpSession session=req.getSession(true);
		
		//PrintWriter out=resp.getWriter();
		String email=req.getParameter("mail");
		String pass=req.getParameter("password");
		Student st=sdao.getStudent(email,pass);
		
		if(st!=null && st.getMail().equals(email)
				          &&st.getPassword().equals(pass) )
		{
			session.setAttribute("Student", st);
			req.setAttribute("success","Login successful!");
		   RequestDispatcher rd=req.getRequestDispatcher("Dash.jsp");
		   rd.forward(req, resp);;
		
			//out.println("<h1> login sucessful</h1>");
		}
		else
			
		{
			req.setAttribute("error","failed to login");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
			
			//out.println("<h1> login failed</h1>");
		}
		
		
	}
	

}
