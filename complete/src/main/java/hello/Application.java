package hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication /*(scanBasePackages= {"hello"})*/
@ComponentScan("hello")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public CommandLineRunner demo(PersonRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Person(1234,"Jack", "Bauer"));
			repository.save(new Person(5678, "Chloe", "O'Brian"));
			repository.save(new Person(1357,"Kim", "Bauer"));
			repository.save(new Person(2468,"David", "Palmer"));
			repository.save(new Person(1245,"Michelle", "Dessler"));
};
	}}
