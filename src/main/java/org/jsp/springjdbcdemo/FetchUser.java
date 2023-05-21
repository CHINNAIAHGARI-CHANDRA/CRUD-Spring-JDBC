package org.jsp.springjdbcdemo;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mysql.cj.jdbc.result.ResultSetFactory;

public class FetchUser {
public static void main(String[] args) {
	
	ApplicationContext context=new ClassPathXmlApplicationContext("spring-jdbc.xml");
	JdbcTemplate template=context.getBean(JdbcTemplate.class);
	String qry="select * from user";
	List<User> user =template.query(qry, new ResultSetExtractor<List<User>>() {

		public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<User> users=new ArrayList<User>();
			while (rs.next()) {
				User u=new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPhone(rs.getLong(3));
				u.setPassword(rs.getString(4));
				users.add(u);
			}
			return users;
		}
		
	});
	System.out.println(user);
}
}
class User {
	private int id;
	private String Name,password;
	private long phone;
	@Override
	public String toString() {
		return "User [id=" + id + ", Name=" + Name + ", password=" + password + ", phone=" + phone + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
}

