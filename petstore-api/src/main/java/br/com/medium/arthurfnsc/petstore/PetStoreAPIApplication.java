package br.com.medium.arthurfnsc.petstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan("br.com.medium.arthurfnsc.petstore")
@EnableSwagger2
@SpringBootApplication
public class PetStoreAPIApplication implements CommandLineRunner {

	class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }
    }

	@Override
	public void run(String... args) throws Exception {
		if ((args.length > 0) && args[0].equals("exitcode")) {
            throw new ExitException();
        }
	}

	public static void main(final String[] args) throws Exception {
        new SpringApplication(PetStoreAPIApplication.class).run(args);
    }
}
