package in.pentagon.studentapp.servlet;

import java.io.IOException;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
@WebServlet("/signup")
public class signup extends HttpServlet {
	

	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 Student s=new Student();//creating object for pojo class
          StudentDAO sdao=new StudentDAOImpl();
         // PrintWriter out= resp.getWriter();
         s.setName(req.getParameter("name"));
          s.setPhone(Long.parseLong(req.getParameter("phone")));
          s.setMail(req.getParameter("mail"));
          s.setBranch(req.getParameter("branch"));
          s.setLoc(req.getParameter("loc"));
          if(req.getParameter("pass").equals(req.getParameter("confirm")))
          {
               s.setPassword(req.getParameter("pass"));
                  boolean res=sdao.insertStudent(s);
		                if(res==true)
		               {
		                	req.setAttribute("success","Data added sucessfuly");
		                	RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
		                	rd.forward(req,resp);
		                	//req.getAttribute("sucess");
		        	    // out.println("<h1> data added sucessfully</h1>");
			               }
			          else
			          {
			        	    req.setAttribute("error","Data added Failed");
		                	RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
		                	 rd.forward(req,resp);
			        	  //out.println("failed to signup");
			          }
		   
		 }
          else {
        	  
        	  req.setAttribute("passmis","password mismatched");
      	        RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
      	         rd.forward(req,resp);
          
        	  //out.println("<h1>password mismatched</h1>");
          }

}
}
