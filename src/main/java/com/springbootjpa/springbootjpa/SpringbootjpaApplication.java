package com.springbootjpa.springbootjpa;

import com.springbootjpa.springbootjpa.entity.Todo;
import com.springbootjpa.springbootjpa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootjpaApplication implements CommandLineRunner {

	@Autowired
	CourseService courseService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Todo todo1 = getTodo(1l, "wake up", "wake up at 6 am ", 1l);
		Todo todo2 = getTodo(1l, "brush teeth", "brush teeth ", 2l);
		Todo todo3 = getTodo(1l, "hair", "comb hair", 3l);
		Todo todo4 = getTodo(1l, "shower", "have shower ", 4l);
		Todo todo5 = getTodo(1l, "breakfast", "have breakfast ", 5l);

		courseService.save(todo1);
		courseService.save(todo2);
		courseService.save(todo3);
		courseService.save(todo4);
		courseService.save(todo5);

		courseService.list().forEach(System.out::println);

	}

	static Todo getTodo(Long version, String title, String description, Long id){
		Todo todo = new Todo();
		todo.setVersion(version);
		todo.setTitle(title);
		todo.setDescription(description);
		todo.setId(id);
		return todo;
	}
}
