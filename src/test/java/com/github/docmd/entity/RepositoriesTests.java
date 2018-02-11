package com.github.docmd.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoriesTests {
	
	@Autowired private Repositories repositories;
	
	@Test
	public void findFirstPage() {
		repositories.forEach( cls -> {
			PagingAndSortingRepository<?, ?> repo = (PagingAndSortingRepository<?, ?>) repositories.getRepositoryFor(cls);
			repo.findAll( new PageRequest(0, 10) );
		});
	}
}
