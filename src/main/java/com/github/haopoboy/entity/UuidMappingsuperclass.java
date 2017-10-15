package com.github.haopoboy.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

@MappedSuperclass
public class UuidMappingsuperclass {
	
	@Id
    @Column(length = 32, updatable = false)
    private String uuid;
	
	@PrePersist
	void prePersist() {
		uuid = UUID.randomUUID()
				.toString()
				.replaceAll("-", "")
				.toUpperCase()
				;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}