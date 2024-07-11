package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yedam.app.**.mapper") //인터페이스를 쭈~욱 얽고 우리가 설정한 mapper location이 가진 쿼리를 쭈~~~욱 읽어서 합친다음 실행시키는 (손대면 죽음뿐)
public class Boot01Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot01Application.class, args);
	}

}
