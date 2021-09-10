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
import com.arab.spring.backendtest.entities.Volunteer;
import com.arab.spring.backendtest.repos.CatRepository;
import com.arab.spring.backendtest.repos.VolunteerRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/cats")
public class CatRESTController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CatRESTController.class);

	@Autowired
	CatRepository catRepository;
	
	@Autowired
	VolunteerRepository volunteerRepository;
	
	@Autowired
	ObjectMapper objectMapper;
	
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
	@RequestMapping("/feedCat/{id}")
	public Cat feedCat(@PathVariable("id") Long id){
		LOGGER.info("Method feedCat is feeding the cat.");
		Cat feedCat = catRepository.findById(id).get();
		String feeder_name = feedCat.getFeeder_name();
		Volunteer volunteer = volunteerRepository.findByName(feeder_name);
		volunteer.setNumber_fed(volunteer.getNumber_fed() + 1);
		return catRepository.save(feedCat);
	} 
	
	@GetMapping
	@RequestMapping("/getcatreport/{id}")
	public ObjectNode generateReport(@PathVariable("id") Long id){
		LOGGER.info("Generating report for cat." + id);
		Cat singleCat = catRepository.findById(id).get();
		ObjectNode objectNode = objectMapper.createObjectNode();
		objectNode.put("id", singleCat.getId());
		objectNode.put("cat_name", singleCat.getCat_name());
		objectNode.put("time_fed", singleCat.getTime_fed().toString());
		objectNode.put("who_fed_it", singleCat.getFeeder_name());
		return objectNode;
		
	}
	
	@GetMapping
	@RequestMapping("/feeders")
	public JsonNode getFeedersReport(){
		LOGGER.info("Generating report for volunteer.");
		List<Object[]> report = catRepository.getFeedersReport();
		JsonNode node = objectMapper.valueToTree(report);
		return node;
		
	}
}
