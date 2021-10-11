package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DemoTest {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		// mysql 
			//Class.forName("oracle.jdbc.driver.OracleDriver");   // oracle
			System.out.println("Driver Loaded successfully");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root@123");
System.out.println("Connected successfully");
Statement stmt = con.createStatement();
int res = stmt.executeUpdate("insert into student values(2,'Ramesh',24)");		// DML Operation 
if(res>0) {
	System.out.println("Record inserted successfully");
}
		//stmt.close();
		//con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
