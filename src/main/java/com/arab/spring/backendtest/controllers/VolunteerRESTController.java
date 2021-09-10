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

import com.arab.spring.backendtest.entities.Volunteer;
import com.arab.spring.backendtest.repos.VolunteerRepository;

@RestController
@RequestMapping("/volunteers")
public class VolunteerRESTController {

	private static final Logger LOGGER = LoggerFactory.getLogger(VolunteerRESTController.class);
	
	@Autowired
	VolunteerRepository volunteerRepository;
	
	@GetMapping
	public List<Volunteer> getAllVolunteer(){
		LOGGER.info("Getting list of entire volunteers");
		return volunteerRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Volunteer getSingleVolunteer(@PathVariable("id") Long id) {
		LOGGER.info("Getting a single volunteer");
		return volunteerRepository.findById(id).get();
	}

	@PostMapping
	public Volunteer addVolunteer(@RequestBody Volunteer volunteer) {
		LOGGER.info("Adding volunteer");
		return volunteerRepository.save(volunteer);
	}
	
}
