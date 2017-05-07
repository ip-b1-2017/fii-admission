package fiiadmission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by rusub on 5/6/2017.
 */
@SpringBootApplication
@EnableSwagger2
public class FiiAdmissionApplication {

    public static void main(String[] args){
        SpringApplication.run(FiiAdmissionApplication.class, args);
    }
}
