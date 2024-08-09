package fr.formation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Jo2024Application {
    public static void main(String[] args) {
        SpringApplication.run(Jo2024Application.class, args);
    }

    @Bean
    CommandLineRunner runner(DataGeneratorApplication appGenerator, SelectApplication appSelect) {
        return appGenerator::run;
        // return appSelect::run;
    }
}
