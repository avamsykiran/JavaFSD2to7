package in.cts.budgetanalysis.txns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TxnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TxnsApplication.class, args);
	}

}
