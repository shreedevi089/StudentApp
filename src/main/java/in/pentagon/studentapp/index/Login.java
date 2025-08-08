package in.pentagon.studentapp.index;

import java.util.ArrayList;
import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Login {
	public static void login()
	{
		Scanner sc=new Scanner(System.in);
		StudentDAO sdao=new StudentDAOImpl();
		System.out.println("--login page--");
		System.out.println("enter the mail id");
		String mail=sc.next();
		System.out.println("enter the password ");
		String pass=sc.next();
		int choice=0;
		Student st=sdao.getStudent(mail,pass);
		if(st!=null)
		{
			System.out.println("login successful! welcome"+" " +st.getName());
			do {
				System.out.println("1.view data");
				System.out.println("2.serach user");
				System.out.println("3. update account");
				System.out.println("4.reset password");
				System.out.println("5.back to main menu");
				if(st.getId()==4) {
					
				System.out.println("6. view all users");
				System.out.println("7.delete the user");
				}
				choice =sc.nextInt();
				switch(choice) {
				case 1:System.out.println(st);
				break;
				case 2: System.out.println("search user");
			            System.out.println("enter the name");
				       String name=sc.next();
				       ArrayList<Student>StudentArray=sdao.getStudent(name);
				       for(Student stud:StudentArray)
				       {
				    	   System.out.println(stud);
				       }
				break;
				case 3: Update.update(st);
				break;
				case 4:Password.reset(st);
				break;
				case 5: System.out.println("going back to main menu");
				break;
				case 6:System.out.println(" view user details");
					   ArrayList<Student> Als=sdao.getStudent();
					   for(Student ss:Als)
					   {
						   System.out.println(ss);
					   }
				break;
				case 7:Delete.delete();
				break;
				default:
					System.out.println("invalid choice");
				
				}
				
				
			}while(choice!=5);
		}		
		
		else
		{
			System.out.println("login failed!");
		}
		
	}

}
