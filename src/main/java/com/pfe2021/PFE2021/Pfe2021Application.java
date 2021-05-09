package com.pfe2021.PFE2021;

import com.pfe2021.PFE2021.repository.AdministrateurRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = AdministrateurRepository.class)
public class Pfe2021Application {

	public static void main(String[] args) {
		SpringApplication.run(Pfe2021Application.class, args);
	}

}
