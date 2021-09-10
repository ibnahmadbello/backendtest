package com.arab.spring.backendtest.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.arab.spring.backendtest.entities.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

	@Query("from Volunteer where volunteer_name =: feeder_name")
	Volunteer findByName(@Param("feeder_name") String feeder_name);

}
