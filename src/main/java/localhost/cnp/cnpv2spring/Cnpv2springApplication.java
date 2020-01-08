package localhost.cnp.cnpv2spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class Cnpv2springApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cnpv2springApplication.class, args);
    }

}
