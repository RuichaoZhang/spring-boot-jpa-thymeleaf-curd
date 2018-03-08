package com.neo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.neo.entity.User;
import com.neo.repository.UserRepository;


@SpringBootApplication
public class JpaThymeleafApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JpaThymeleafApplication.class);
    }
    @Autowired 
    UserRepository repository;

	public @PostConstruct void init() {
		repository.deleteAll();
		User user = new User();
		user.setAge(12);
		user.setPassword("123456");
		user.setUserName("admin");
		user.setUserType("admin");
		repository.save(user);
	}
    public static void main(String[] args) throws Exception {
        SpringApplication.run(JpaThymeleafApplication.class, args);
    }
}

