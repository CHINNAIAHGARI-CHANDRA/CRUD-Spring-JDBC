package org.jsp.springjdbcdemo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

public class UpdateUser {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter your details for update id,name,phone and password");
		final int id=s.nextInt();
		final String name=s.next();
		final long phone=s.nextLong();
		final String password=s.next();
		String qry="update user set name=?,phone=?,password=? where id=?";
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-jdbc.xml");
		JdbcTemplate template=context.getBean(JdbcTemplate.class);
		int r=template.execute(qry, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(4, id);
				ps.setString(1, name);
				ps.setLong(2, phone);
				ps.setString(3, password);
				return ps.executeUpdate();
			}
		});
     System.out.println(r +" rows are inserted ");
	}
}
