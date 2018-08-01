package em.fire.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class FireBackendApplication {

	@RequestMapping("/")
	@ResponseBody
	String fire() {
		return "Fire Backend!";
	}

	public static void main(String[] args) {
		SpringApplication.run(FireBackendApplication.class, args);
	}
}
