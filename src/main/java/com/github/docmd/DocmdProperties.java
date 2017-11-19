package com.github.docmd;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "docmd")
public class DocmdProperties {
    public enum StorageType {LOCAL}
    private static final Logger logger = LoggerFactory.getLogger(DocmdProperties.class);
    private StorageType storageType = StorageType.LOCAL;
    private Path storagePath = Paths.get("data");
    
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

    public Path getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(Path storagePath) {
        this.storagePath = storagePath;
    }

    @Override
    public String toString() {
        return String.format("DocmdProperties [storageType=%s, storagePath=%s]", storageType, storagePath);
    }
}