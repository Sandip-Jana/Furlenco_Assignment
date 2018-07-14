package com.sandipjana;

import com.sandipjana.model.Student;
import com.sandipjana.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackageClasses = {Student.class})
@EnableJpaRepositories(basePackageClasses = {StudentRepository.class})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
