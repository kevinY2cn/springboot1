package dk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class DkApplication {

	public static void main(String[] args) {
		SpringApplication.run(DkApplication.class, args);
	}

}
