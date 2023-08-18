package by.tms.job_finder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class JobFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobFinderApplication.class, args);
    }

}
