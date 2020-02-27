package crud_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = {"crud_api","com.practo.commons.cache","crud_api"})
@EnableJpaAuditing
@EnableCaching
public class CrudApi {

	public static void main(String[] args) {
		
		SpringApplication.run(CrudApi.class, args);
		
		
	}

}
