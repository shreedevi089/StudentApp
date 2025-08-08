package in.pentagon.studentapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Password {

	public static void reset(Student st) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		 System.out.print("Enter  phone: ");
	        Long phone = sc.nextLong();

	        System.out.print("Enter  mail: ");
	        
	        String mail = sc.next();
	        StudentDAO sdao = new StudentDAOImpl();
	        //Student student = sdao.getStudent(phone, mail); 
	        if(st.getPhone().equals(phone) && st.getMail().equalsIgnoreCase(mail))
	        {
	        	System.out.println("set new password");
	        	String pass=sc.next();
	        	System.out.println("confirm  password");
	        	String confirm=sc.next();
	        	if(pass.equals(confirm))
	        	{    st.setPassword(pass);
	        		boolean res=sdao.updateStudent(st);
	        		if(res)
	        		{
	        			System.out.println("password update succesfully ");
	        		}
	        		else
	        		{
	        			System.out.println("failed to update password");
	        		}
	        	}
	        	else
	        	{
	        		System.out.println("mismatched");
	        	}
	        	
	        	
	        }
	        else
	        {
	        	System.out.println("Incorrect phone and mail");
	        }
		
	}

}
