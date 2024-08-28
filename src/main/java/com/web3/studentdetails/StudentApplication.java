package com.web3.studentdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring Application
 * starting point of spring application.
 *
 * @author  Naveen
 * @version 1.0
 * @since   2022-09-21
 */
@SpringBootApplication
public class StudentApplication {
  /**
   * This is the main method. Starting point of the Application.
   * @param args class name is sent.
   */
  public static void main(final String[] args) {
    SpringApplication.run(StudentApplication.class, args);
  }

  /**
   * This code is done by Lokesh.
   * @return WebMvcConfigurer
   */
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
      }
    };
  }

  /**
   * Used to suppress the Utility exception in checkstyle.
   */
  public void dummy() {

  }

}
