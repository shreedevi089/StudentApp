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
@WebServlet("/forgot")
public class Forgotpassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		StudentDAO sdao=new StudentDAOImpl();
		//Student s=new Student();
		//PrintWriter out=resp.getWriter();
		Long phone=Long.parseLong(req.getParameter("phone"));
		
		String email=req.getParameter("mail");
		Student s=sdao.getStudent(phone, email);
		if(s!=null)
		{
			if(req.getParameter("pass").equals(req.getParameter("cofirm")))
			{
				s.setPassword("pass");
				boolean res=sdao.updateStudent(s);
				if(res)
					
				{
					req.setAttribute("Success"," password update sucessfully ");
                	RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
                	rd.forward(req,resp);
					//out.println("<h1> update password successfully</h1>");
				}
				else
				{
					  req.setAttribute("Error","failed to update");
	                   RequestDispatcher rd=req.getRequestDispatcher("ForgotPass.jsp");
	                 rd.forward(req,resp);
					//out.println("<h1>  failed to update password</h1>");
				}
			}
			
			else
				{
				req.setAttribute("Error", "Passwords do not match");
			    RequestDispatcher rd = req.getRequestDispatcher("ForgotPass.jsp");
			    rd.forward(req, resp);//out.println("<h1>password mismatched<h1>");
				}
		}
	}
}
		
//		String pass=req.getParameter("pass");
//		s.setPassword(pass);
//		String passc=req.getParameter("cofirm");
//		s.setPassword(passc);
//		
//		if(pass.equals(passc))
//		{
//			
//			boolean res=sdao.updateStudent(s);
//			if(res==true)
//			{
//				out.println("update  succesfully");
//			}
//			else
//			{
//				out.println("failed to update");
//			}
//		}
//		else
//		{
//			out.println("<h1>password mismatched<h1>");
//		}
//		//String pass=req.getParameter("password");
//		
//		
//		
//	}
//
//}
