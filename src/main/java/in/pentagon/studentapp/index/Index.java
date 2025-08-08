package in.pentagon.studentapp.index;

import java.util.Scanner;

public class Index {
	public  static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		int choice=0;
		System.out.println("welcome to student application");
		do {
			System.out.println("1. signup");
			System.out.println("2. login");
			System.out.println("3. forgot password");
			
			System.out.println("4. exit");
			choice=sc.nextInt();
			switch(choice) {
			case 1:Signup.signup();
				   break;
			case 2:Login.login();
				   break;
			case 3:Forgotpassword.forgot();
				   break;
			case 4:System.out.println("Application Closed");
				   break;
			default:
				 System.out.println("invalid choice ! plese enter valid choice");
				   		   	   	   
			}
			
			
		}while(choice!=4);
		
	}
		
	

}
 