package em.fire.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("em.fire.backend.*")
public class FireBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FireBackendApplication.class, args);
	}
}
