package com.Saat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.YusufZiya.Configuration.GlobalProperties;

@SpringBootApplication
@ComponentScan(basePackages = {"com.Saat"} )
@EnableJpaRepositories(basePackages = {"com.Saat"} )
@EntityScan(basePackages = {"com.Saat"})
@EnableConfigurationProperties(value = GlobalProperties.class )
public class BackendSaatApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendSaatApplication.class, args);
	}

}
