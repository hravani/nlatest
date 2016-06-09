package au.gov.nlatest.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 * @author hiten
 *
 */
//convenient way to add @Configuration, @EnableAutoConfiguration, @ComponentScan
@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
    	log.debug("Starting...");
        SpringApplication.run(Application.class, args);
    }

}
