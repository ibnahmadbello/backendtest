package com.arab.spring.backendtest.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arab.spring.backendtest.entities.Cat;

public interface CatRepository extends JpaRepository<Cat, Long> {

}
