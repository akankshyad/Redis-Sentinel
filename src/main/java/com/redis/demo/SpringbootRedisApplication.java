package com.redis.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@SpringBootApplication
@RestController

public class SpringbootRedisApplication {



	private static final String KEY = "REDISDEMO";

	@Autowired
	private StringRedisTemplate template;

	@GetMapping("/{name}")
	public void addToSet(@PathVariable String name) {
		this.template.opsForSet().add(KEY, name);
	}

	@GetMapping("/get")
	public Set<String> getKeyValues() {
		return this.template.opsForSet().members(KEY);
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringbootRedisApplication.class, args);
	}

}
