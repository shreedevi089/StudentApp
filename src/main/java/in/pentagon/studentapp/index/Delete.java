package in.pentagon.studentapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;

public class Delete {

	public static void delete() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		StudentDAO sdao=new StudentDAOImpl();
		System.out.println("enter the student id ");
		int id=sc.nextInt();
		boolean delete=sdao.deleteStudent(id);
		if(delete)
		{
			System.out.println("delete account successfuly ");
		}
		else
		{
			System.out.println("failed to delete");
		}
		
		
		
	}
	
	

}
