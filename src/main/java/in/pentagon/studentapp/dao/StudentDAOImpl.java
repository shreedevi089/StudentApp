package in.pentagon.studentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.pentagon.studentapp.connection.Connector;
import in.pentagon.studentapp.dto.Student;

public class StudentDAOImpl implements StudentDAO {
	private Connection con;
	 public StudentDAOImpl()
	 {
		 this.con=Connector.requestConnection();
	 }

	@Override
	public boolean insertStudent(Student s) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		//String query="insert into Students values(?,?,?,?,?,?,sysdate())";
		 String query = "INSERT INTO Students (Name, phone, mail, branch, loc, password, Date) VALUES (?, ?, ?, ?, ?, ?, sysdate())";
		int i=0;
		  try {
			ps=con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMail());
            ps.setString(4, s.getBranch());
            ps.setString(5,s.getLoc());
            ps.setString(6, s.getPassword());
            
            i=ps.executeUpdate();
           
            
		} catch (SQLException e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  if(i>0) {
          	return true;
          }
		  else
		  {
			  return false;  
		  }
		
		
	}

	@Override
	public boolean updateStudent(Student s) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		int i=0;
		String query="update Students set  name=?,phone=?, mail=?,branch=?,loc=?,date=sysdate(), password=? where id=?";
		try {
			ps=con.prepareStatement(query);
			
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMail());
            ps.setString(4, s.getBranch());
            ps.setString(5,s.getLoc());
            ps.setString(6, s.getPassword());
            ps.setInt(7, s.getId());
			 i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0)
		{
		return true;
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		int i=0;
		String query="delete from Students where id=?";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(i>0)
		 {
			return true; 
		 }
		 else
		 {
		return false;
		 }
	}

	@Override
	public Student getStudent(String mail, String password) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		Student s=null;
		String query="select * from Students where mail=? and password=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,mail);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("loc"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				
				
		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	@Override
	public Student getStudent(Long phone, String mail) {
	    PreparedStatement ps = null;
	    Student s = null;
	    String query = "SELECT * FROM Students WHERE phone = ? AND mail = ?";
	    try {
	        ps = con.prepareStatement(query);
	        ps.setLong(1, phone);
	        ps.setString(2, mail);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            s = new Student();
	            s.setId(rs.getInt("id"));
	            s.setName(rs.getString("name"));
	            s.setPhone(rs.getLong("phone"));
	            s.setMail(rs.getString("mail"));
	            s.setBranch(rs.getString("branch"));
	            s.setLoc(rs.getString("loc"));
	            s.setPassword(rs.getString("password"));
	            s.setDate(rs.getString("date"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return s;
	}



	@Override
	public ArrayList<Student> getStudent(String n) {
		ArrayList<Student> alss=new ArrayList<>();
		// TODO Auto-generated method stub
		Student stud=null;
		PreparedStatement ps=null;
		String query="select * from Students where name=?";
		try {
			 ps=con.prepareStatement(query);
			
			ps.setString(1, n );
			 ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				 stud=new Student();
					stud.setId(rs.getInt("id"));
					stud.setName(rs.getString("name"));
					stud.setPhone(rs.getLong("phone"));
					stud.setMail(rs.getString("mail"));
					stud.setBranch(rs.getString("branch"));
					stud.setLoc(rs.getString("loc"));
					stud.setPassword(rs.getString("password"));
					stud.setDate(rs.getString("date"));
					alss.add(stud);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alss;
	}

	@Override
	public ArrayList<Student> getStudent() {
		// TODO Auto-generated method stub
		ArrayList<Student> als=new ArrayList<>();
		Student s=null;
		PreparedStatement ps=null;
		String query="select * from Students";
		try {
			ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{   s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("loc"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				als.add(s);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return als;
	}
	

}
