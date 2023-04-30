package in.Rushikesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.Rushikesh.entity.Plan;
import in.Rushikesh.service.PlanServiceImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

}
