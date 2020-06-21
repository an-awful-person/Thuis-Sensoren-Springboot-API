package thuissensoren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories({"thuissensoren"})
@EntityScan({"thuissensoren.model"})
public class ThuisSensorenApp {

	public static void main(String[] args) {
		SpringApplication.run(ThuisSensorenApp.class, args);
		System.out.println("Started...");
	}

}
