package com.shrey.moviebooking.coreservice.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author Shrey
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "theatreServiceEntityManagerFactory", transactionManagerRef = "transactionManager", basePackages = {
		"com.shrey.moviebooking" })
public class CoreServiceConfig {

	@Bean("theatreServiceEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("dataSource") DataSource dataSource,
			EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataSource).packages("com.shrey.moviebooking.coreservice.models").persistenceUnit("H2DB").build();
	}

	@Bean("transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("theatreServiceEntityManagerFactory") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}

}
