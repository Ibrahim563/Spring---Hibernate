package ConnectorPack;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

	public static void main(String[] args) {

		String url="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String name = "hbstudent";
		String password = "hbstudent";	
		
		try {
			
			System.out.println("Setting up connection");
			Connection conn=DriverManager.getConnection(url,name,password);
			System.out.println("Connected successfully");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
