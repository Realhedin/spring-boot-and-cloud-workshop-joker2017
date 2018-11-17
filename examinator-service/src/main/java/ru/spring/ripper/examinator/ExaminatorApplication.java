package ru.spring.ripper.examinator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author tolkv
 * @version 24/10/2017
 */
@SpringBootApplication
@EnableConfigurationProperties(ExternalServiceProperties.class)
public class ExaminatorApplication {

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  public static void main(String[] args) {
    SpringApplication.run(ExaminatorApplication.class, args);
  }
}
