package org.jsp.springjdbcdemo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

public class DeleteUser {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter id for delete");
		final int id=s.nextInt();
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-jdbc.xml");
		JdbcTemplate template=context.getBean(JdbcTemplate.class);
		String qry="delete from user where id=?";
		int r=template.execute(qry, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, id);
				return ps.executeUpdate();
			}
		});
		System.out.println(r +"rows deleted");
	}

}
