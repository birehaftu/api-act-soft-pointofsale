package edu.act.apiactsoftpointofsale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApiActSoftPointofsaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiActSoftPointofsaleApplication.class, args);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000"
                                //,"https://money-transfer-web-app-actse.herokuapp.com",
                                //"https://biniama.github.io/money-transfer-web-app-actse/"
                        );
                //.allowedOrigins("*");
            }
        };
    }

}
