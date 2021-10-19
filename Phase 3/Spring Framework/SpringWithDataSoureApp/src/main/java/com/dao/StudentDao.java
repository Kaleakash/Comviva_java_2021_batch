package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Student;

@Repository						// This is Dao layer specific annotation 
public class StudentDao {

	@Autowired
	DataSource ds;				// before spring framework, look up from application server using JDNI 
	
	public int storeStudentRecord(Student std) {
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into student values(?,?,?,?)");
			pstmt.setInt(1, std.getSid());
			pstmt.setString(2, std.getName());
			pstmt.setInt(3, std.getAge());
			pstmt.setInt(4, 111);
			return pstmt.executeUpdate();
		} catch (Exception e) {
		System.out.println(e);
		return 0;
		}
	}
}
