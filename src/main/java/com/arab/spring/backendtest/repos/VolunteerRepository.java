package com.arab.spring.backendtest.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arab.spring.backendtest.entities.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

}
