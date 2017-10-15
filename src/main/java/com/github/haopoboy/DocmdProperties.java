package com.github.haopoboy;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "docmd")
public class DocmdProperties {
	public enum StorageType {LOCAL};
	private static final Logger logger = LoggerFactory.getLogger(DocmdProperties.class);
	private StorageType storageType = StorageType.LOCAL;
	private String storagePath = "data";
	
	@PostConstruct
	void post() {
		logger.info("Using {}", this);
	}

	public StorageType getStorageType() {
		return storageType;
	}

	public void setStorageType(StorageType storageType) {
		this.storageType = storageType;
	}

	public String getStoragePath() {
		return storagePath;
	}

	public void setStoragePath(String storagePath) {
		this.storagePath = storagePath;
	}

	@Override
	public String toString() {
		return String.format("DocmdProperties [storageType=%s, storagePath=%s]", storageType, storagePath);
	}
}