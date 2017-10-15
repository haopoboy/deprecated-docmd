package com.github.haopoboy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.haopoboy.entity.Docmd;

public interface DocmdRepository extends JpaRepository<Docmd, String> {
}