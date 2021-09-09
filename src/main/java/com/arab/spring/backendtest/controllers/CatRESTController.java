package com.arab.spring.backendtest.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arab.spring.backendtest.entities.Cat;
import com.arab.spring.backendtest.repos.CatRepository;

@RestController
@RequestMapping("/cats")
public class CatRESTController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CatRESTController.class);

	@Autowired
	CatRepository catRepository;
	
	@GetMapping
	public List<Cat> getAllCat(){
		LOGGER.info("msg", "Method getAllCats is called");
		return catRepository.findAll();
	}
	
	
//	@GetMapping
//	public List<Cat> getHungryCats(){
//		LOGGER.info("msg", "Method getHungryCats is called");
//		return catRepository.findAll();
//	}
	
	@GetMapping("/{id}")
	public Cat getSingleCat(@PathVariable("id") Long id) {
		LOGGER.info("msg", "Method getSingleCat is called");
		return catRepository.findById(id).get();
	}

	@PostMapping
	public Cat addCat(@RequestBody Cat cat) {
		LOGGER.info("msg", "Method addCat is called");
		return catRepository.save(cat);
	}
}