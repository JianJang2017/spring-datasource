package com.jianzhang.db;

import com.jianzhang.db.bean.Student;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@EnableTransactionManagement
@RestController
@MapperScan(basePackages = "com.jianzhang.db.mapper")
@SpringBootApplication
public class SpringDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatasourceApplication.class, args);
	}
	@GetMapping("/getStudent")
	public Student getStudent(){
		Student student = new Student();
		student.setAge(22);

		student.setName("张三");
		return student;
	}
}
