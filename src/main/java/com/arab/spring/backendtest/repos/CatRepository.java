package com.arab.spring.backendtest.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arab.spring.backendtest.entities.Cat;

public interface CatRepository extends JpaRepository<Cat, Long> {


	@Query("from Cat where (hour(current_time) - (extract(hour from time_fed))) > 4")
	public List<Cat> findHungryCat();

	@Query("select feeder_name, count(feeder_name) from Cat group by feeder_name")
	public List<Object[]> getFeedersReport();

}
