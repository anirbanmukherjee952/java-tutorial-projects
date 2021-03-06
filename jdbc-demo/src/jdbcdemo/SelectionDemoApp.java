package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectionDemoApp {
	
	public static void main(String[] args) {
		// communication with MySQL Database
		
		// Step 0: form required info
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String username = "root";
		String password = "";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// Step 1: register/load the Driver class
			Class.forName(driver);
			
			// Step 2: get the Connection object
			conn = DriverManager.getConnection(url, username, password);
			
			// Step 3: define the SQL query
			String sqlQuery = "SELECT id, first_name, last_name, course FROM student ORDER BY first_name";
			
			// Step 4: get the Statement object
			stmt = conn.createStatement();
			
			// Step 5: run the SQL query and fetch the result
			rs = stmt.executeQuery(sqlQuery);
			
			// Step 6: extracting tuples from ResultSet
			List<Student> students = new ArrayList<>();
			int iteration = 0;
			
			while(rs.next()) {
				
				System.out.print("Iteration: " + (++iteration) + " | ");
				
				Student theStudent = new Student();
				
				theStudent.setId(rs.getInt("id"));
				
				theStudent.setFirstName(rs.getString("first_name"));
				
				theStudent.setLastName(rs.getString("last_name"));
				
				theStudent.setCourse(rs.getString("course"));
				
				System.out.println(theStudent);
				
				students.add(theStudent);
			}
			
			System.out.println("List of students: " + students);
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			// Step 7: close the objects
			try {
				conn.close();
				stmt.close();
				rs.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
