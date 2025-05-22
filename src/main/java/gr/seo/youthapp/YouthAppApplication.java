package gr.seo.youthapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The YouthAppApplication class serves as the entry point for the Spring Boot application. It
 * initializes and runs the application using the SpringApplication.run method.
 */
@SpringBootApplication
public class YouthAppApplication {

  /**
   * The main method serves as the entry point of the application. It uses Spring Boot's
   * SpringApplication.run method to bootstrap the application.
   *
   * @param args command-line arguments passed to the application
   */
  public static void main(String[] args) {
    SpringApplication.run(YouthAppApplication.class, args);
  }
}
