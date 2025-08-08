package in.pentagon.studentapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Update {
	public static void update(Student s)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("update account"); 
		StudentDAO sdao=new  StudentDAOImpl();
		
		int choice=0;
		do {
			
			System.out.println("enter the field to be updated");
			
			
			System.out.println("1:name");
			System.out.println("2:phone");
			System.out.println("3:mail");
			System.out.println("4:branch");
			System.out.println("5:loc");
			System.out.println("6:password");
		
			choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:System.out.println("enter the name");
			       s.setName(sc.next());
			       break;
			case 2:System.out.println("enter phone no");
				  s.setPhone(sc.nextLong());
			break;
			case 3:System.out.println("enter mail");
				s.setMail(sc.next());
			break;
			case 4:System.out.println("enter branch");
				s.setBranch(sc.next());
			break;
			case 5:System.out.println("enter loc");
				s.setLoc(sc.next());
			break;
			case 6:System.out.println("enter password");
				s.setPassword(sc.next());
			break;
			default:
				System.out.println("invalid choice");
			
			}
			 boolean res =sdao.updateStudent(s);
			 if(res==true)
			 {
				 System.out.println("update succesfully");
				 
			 }
			 else
			 {
				 System.out.println("update failed");
			 }
			
			
			
		}while(choice!=6);
		
		
	}

}
