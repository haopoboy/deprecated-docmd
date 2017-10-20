package com.github.haopoboy.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.haopoboy.DocmdProperties;
import com.github.haopoboy.entity.Category;
import com.github.haopoboy.entity.Docmd;
import com.github.haopoboy.entity.MdContent;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalDocmdServiceImplTests {
	
	@Autowired private LocalDocmdServiceImpl impl;
	@Autowired private DocmdProperties properties;
	
	@Before
	public void rmdir() throws IOException {
		Path path = Paths.get( properties.getStoragePath() );
		FileUtils.deleteDirectory( path.toFile() );
	}

	@Test
	public void save() {
		// Make sure data doesn't exist.
		Path path = Paths.get( properties.getStoragePath() );
		assertThat(path)
			.as("Path[%s] must not exist to make sure auto creation.", path)
			.doesNotExist()
			;
		
		Docmd docmd = new Docmd();
		docmd.setName("Tutorial");
		Category starter = new Category();
		MdContent md = new MdContent();
		md.setName("README");
		md.setContent("Hello world");
		docmd.getCategories().add(starter);
		docmd.getList().add(md);
		impl.save(docmd);

		// Storage path
		assertThat(path).exists().isDirectory();
		
		// Tutorial
		Path tutorial = Paths.get(String.format("%s/%s", path.toString(), "Tutorial"));
		assertThat(tutorial).isDirectory();
		
		// README.md
		Path readme = Paths.get( String.format("%s/%s", tutorial.toString(), "README.md") );
		assertThat(readme)
			.exists()
			.isRegularFile()
			.hasContent("Hello world")
			;
	}

}
