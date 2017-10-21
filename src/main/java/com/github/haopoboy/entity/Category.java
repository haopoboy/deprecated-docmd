package com.github.haopoboy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity 
@DynamicInsert @DynamicUpdate
public class Category extends UuidMappingsuperclass {

    private String name;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<MdContent> list = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MdContent> getList() {
        return list;
    }

    public void setList(List<MdContent> list) {
        this.list = list;
    }
}
