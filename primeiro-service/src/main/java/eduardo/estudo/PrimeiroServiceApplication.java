package eduardo.estudo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = {"outside.estudo", "eduardo.estudo"})
public class PrimeiroServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(PrimeiroServiceApplication.class,
				args);
		Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
	}
}