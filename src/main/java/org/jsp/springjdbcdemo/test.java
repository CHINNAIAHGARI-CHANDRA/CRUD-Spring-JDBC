package org.jsp.springjdbcdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class test {
public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("spring-jdbc.xml");
	JdbcTemplate template=context.getBean(JdbcTemplate.class);
	template.execute("create table user(id int not null,name varchar(45) not null,phone bigint unique not null,password varchar(43) not null,primary key(id))");
	System.out.println("table is created");
}
}
