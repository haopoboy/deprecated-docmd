package com.github.haopoboy.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import com.github.haopoboy.DocmdProperties;
import com.github.haopoboy.entity.Docmd;
import com.github.haopoboy.entity.MdContent;
import com.github.haopoboy.repo.DocmdRepository;
import com.github.haopoboy.util.Util;

@Service
@ConditionalOnProperty(name = "docmd.storage-type", havingValue = "LOCAL", matchIfMissing = true)
public class LocalDocmdServiceImpl implements DocmdService {

	private static final String YAML_NAME = "docmd.yml";
	@Autowired private DocmdProperties properties;
	@Autowired private DocmdRepository repository;

	@PostConstruct
	void postConstruct() {
		File dir = Paths.get( properties.getStoragePath() ).toFile();
		mkdirs(dir);
	}

	@Transactional
	public void save(Docmd docmd) {
		repository.save(docmd);
		createRootIfNotExists(docmd);
		writeToYaml(docmd);
		docmd.getList().forEach( md -> writeContent(docmd, md) );
	}

	void writeToYaml(Docmd docmd) {
		Yaml yaml = Util.createDefaultYaml();
		String content = yaml.dump(docmd);
		String path = generatePath( String.format("%s/%s", docmd.getName(), YAML_NAME) );
		writeContent(path, content);
	}
	
	void writeToYaml(String name, Map<String, Object> map) {
		Yaml yaml = new Yaml();
		String content = yaml.dump(map);
		String path = generatePath( String.format("%s/%s", name, YAML_NAME) );
		writeContent(path, content);
	}

	void writeContent(String path, String content) {
		writeContent( Paths.get(path), content );
	}

	void writeContent(Path path, String content) {
		try {
			Files.write( path, content.getBytes() );
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	void writeContent(Docmd docmd, MdContent md) {
		String stringPath = generatePath( docmd.getName() );
		Path path = Paths.get( String.format("%s/%s.md", stringPath, md.getName()) );
		writeContent( path, md.getContent() );
	}

	void createRootIfNotExists(Docmd docmd) {
		String stringPath = generatePath( docmd.getName() );
		Path root = Paths.get(stringPath);
		File rootDir = root.toFile();
		mkdirs(rootDir);
	}

	void mkdirs(File dir) {
		if ( !dir.exists() && !dir.mkdirs() ) {
			throw new IllegalStateException("Couldn't create dir: " + dir);
		}
	}

	String generatePath(String name) {
		return String.format("%s/%s", properties.getStoragePath(), name);
	}
}
