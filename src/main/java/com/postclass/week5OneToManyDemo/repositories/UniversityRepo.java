package com.postclass.week5OneToManyDemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.postclass.week5OneToManyDemo.models.University;





@Repository
public interface UniversityRepo extends CrudRepository<University, Long> {

	List<University> findAll(); // Much like SELECT * FROM university
	
	List<University> findAllByOrderByNameDesc(); // Much like SELECT * FROM university ORDER BY name DESC
}
