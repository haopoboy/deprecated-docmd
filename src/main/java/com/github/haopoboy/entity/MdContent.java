package com.github.haopoboy.entity;

import javax.persistence.Entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity 
@DynamicInsert @DynamicUpdate
public class MdContent extends UuidMappingsuperclass {
	
	private String name;
	private String content;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
