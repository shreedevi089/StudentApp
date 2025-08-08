package in.pentagon.studentapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Signup {
	public static void signup()

	{
		Scanner sc=new Scanner(System.in);
		
		StudentDAO sdao = new StudentDAOImpl();
		Student s=new Student();
		System.out.println("<--student signup-->");
		System.out.println("enter the name");
		s.setName(sc.next());
		System.out.println("enter the phone");
		s.setPhone(sc.nextLong());
		System.out.println("enter the email");
		s.setMail(sc.next());
		System.out.println("enter the branch");
		s.setBranch(sc.next());
		System.out.println("ente the loc");
		s.setLoc(sc.next());
		System.out.println(" set new password ");
		String pass=sc.next();
		//s.setPassword(pass);
		System.out.println("confirm the password");
		String confpass=sc.next();
		if(pass.equals(confpass))
		{
			s.setPassword(confpass);
			boolean res=sdao.insertStudent(s);
			if(res==true)
			{
				System.out.println("data addes succesfully");
			}
			else
			{
				System.out.println("failed to added");
			}
		}
		else
		{
			System.out.println("password mismatched");
		}
		
	}
}
