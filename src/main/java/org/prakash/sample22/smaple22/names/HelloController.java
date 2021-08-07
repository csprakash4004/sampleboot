package org.prakash.sample22.smaple22.names;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class HelloController {

	@GetMapping("/hello")
	public String sayHello() {
		log.info("logging hello.");
		return "Hello!! " + java.time.LocalDateTime.now().toString();
	}

}
