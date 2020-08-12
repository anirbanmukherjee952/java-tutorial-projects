package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertionDemoApp {
	
	public static void main(String[] args) {
		// communication with MySQL Database
		
		// Step 0: form required info
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String username = "root";
		String password = "";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// Step 1: register/load the Driver class
			Class.forName(driver);
			
			// Step 2: get the Connection object
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
			
			// Step 3: define the SQL query
			String sqlQuery = "INSERT INTO student(first_name, last_name, course) VALUES (?, ?, ?), (?, ?, ?), (?, ?, ?)";
			
			// Step 4: get the Statement object
			pstmt = conn.prepareStatement(sqlQuery);
			
			pstmt.setString(1, "Dip");
			pstmt.setString(2, "Das");
			pstmt.setString(3, "CSE");
			
			pstmt.setString(4, "Ritwika");
			pstmt.setString(5, "Das");
			pstmt.setString(6, "EE");
			
			pstmt.setString(7, "Soumi");
			pstmt.setString(8, "Sarkar");
			pstmt.setString(9, "CSE");
			
			// Step 5: run the SQL query and fetch the result
			int count = pstmt.executeUpdate();
			conn.commit();
			
			System.out.println("Insertion Successful: " + count + " rows inserted");
		} 
		catch (ClassNotFoundException | SQLException e) {
			try {
				conn.rollback();
			} 
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			e.printStackTrace();
		}
		finally {
			
			// Step 7: close the objects
			try {
				conn.close();
				pstmt.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
