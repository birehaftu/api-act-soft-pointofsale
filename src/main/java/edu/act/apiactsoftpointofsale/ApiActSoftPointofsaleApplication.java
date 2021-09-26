package edu.act.apiactsoftpointofsale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApiA /*.allowedOrigins("http://localhost:3000"
                                ,"http://localhost:*"
                                ,"http://localhost:38262"
                        );*/
                .allowedOrigins("*");
            }
        };
    }

}
