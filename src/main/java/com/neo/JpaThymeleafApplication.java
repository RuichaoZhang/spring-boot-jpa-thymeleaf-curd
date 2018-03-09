package com.neo;

import java.util.ArrayList;
import java.util.List;

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
		List<User> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			User user = new User();
			user.setAge(12);
			user.setPassword("123456");
			if(i==0) {
				user.setUserName("admin");
			}else {
				user.setUserName("admin"+i);
			}
			
			user.setUserType("admin");
			list.add(user);
			
		}
		repository.save(list);
	}
    public static void main(String[] args) throws Exception {
        SpringApplication.run(JpaThymeleafApplication.class, args);
    }
}

