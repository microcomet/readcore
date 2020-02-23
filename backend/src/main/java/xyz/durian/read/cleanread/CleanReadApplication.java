package xyz.durian.read.cleanread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"xyz.durian.read.cleanread", "xyz.durian.read.datalayer"})
public class CleanReadApplication {

    public static void main(String[] args) {
        SpringApplication.run(CleanReadApplication.class, args);
    }

}
