package com.postclass.week5OneToManyDemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.postclass.week5OneToManyDemo.models.Hall;

@Repository
public interface HallRepo extends CrudRepository<Hall, Long>{
	
	List<Hall> findAll(); // get all hall
	
	List<Hall> findAllByOrderByHallNameDesc(); // get all hall order by name desc
}
