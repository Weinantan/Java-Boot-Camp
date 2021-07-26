package bootcamp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan({"bootcamp.controller"})
@SpringBootApplication
public class Service {
    public static void main(final String args[]) {
        SpringApplication.run(Service.class,args);
    }
}
