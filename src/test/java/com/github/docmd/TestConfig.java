package com.github.docmd;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.support.Repositories;

@Configuration
public class TestConfig {

	@Bean
	public Repositories repositories(ListableBeanFactory factory) {
		return new Repositories(factory);
	}
}
