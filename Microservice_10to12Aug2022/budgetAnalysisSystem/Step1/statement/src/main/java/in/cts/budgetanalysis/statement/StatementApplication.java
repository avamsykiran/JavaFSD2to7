package in.cts.budgetanalysis.statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StatementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatementApplication.class, args);
	}

}
