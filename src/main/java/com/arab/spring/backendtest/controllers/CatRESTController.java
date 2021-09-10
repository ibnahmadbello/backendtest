package com.arab.spring.backendtest.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		LOGGER.info("Method getAllCats is called");
		return catRepository.findAll();
	}
	
	
	@GetMapping
	@RequestMapping("/hungrycats")
	public List<Cat> getHungryCats(){
		LOGGER.info("Method getHungryCats is called");
		return catRepository.findHungryCat();
	}
	
	@GetMapping("/{id}")
	public Cat getSingleCat(@PathVariable("id") Long id) {
		LOGGER.info("Method getSingleCat is called");
		return catRepository.findById(id).get();
	}

	@PostMapping
	public Cat addCat(@RequestBody Cat cat) {
		LOGGER.info("Method addCat is called");
		return catRepository.save(cat);
	}

	@PutMapping
	@RequestMapping("/feedCat")
	public Cat feedCat(@RequestBody Cat cat){
		return catRepository.save(cat);
	} 
	
	
	public void generateReport(Cat cat){
		
	}
	//TODO generate report for a cat
}
