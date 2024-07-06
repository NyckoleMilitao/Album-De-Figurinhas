package ilab.projeto.up.ilab.up.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
		    public void addCorsMappings(CorsRegistry registry) {
		        registry.addMapping("/**")
		                .allowedOrigins("http://localhost:8080/", "http://169.57.150.59:8004/")
		                .allowedMethods("GET", "POST", "PUT", "DELETE")
		                .allowedHeaders("*")
		                .allowCredentials(true);
		    }
		};
	}
}
