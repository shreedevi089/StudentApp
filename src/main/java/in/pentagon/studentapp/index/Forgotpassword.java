package in.pentagon.studentapp.index;

import java.util.Scanner;
import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Forgotpassword {

    public static void forgot() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Forgot Password ---");

        System.out.print("Enter  phone: ");
        Long phone = sc.nextLong();

        System.out.print("Enter  mail: ");
        String mail = sc.next();

        StudentDAO sdao = new StudentDAOImpl();
        Student student = sdao.getStudent(phone, mail); //  user

        if (student != null) {
            System.out.print("Enter new password: ");
            String pass1 = sc.next();

            System.out.print("Confirm password: ");
            String pass2 = sc.next();

            if (pass1.equals(pass2)) {
                student.setPassword(pass1); 
                // set new password
                boolean updated = sdao.updateStudent(student); // update in DB

                if (updated) {
                    System.out.println("Password updated successfully.");
                }
                else 
                {
                    System.out.println("Failed to update password.");
                }
            }
            else
            {
                System.out.println("Passwords do not match!");
            }
        } 
        else
        {
            System.out.println("No student found with given phone and mail.");
        }
    }
}
