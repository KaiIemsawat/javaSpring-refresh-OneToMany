package com.postclass.week5OneToManyDemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postclass.week5OneToManyDemo.models.University;
import com.postclass.week5OneToManyDemo.repositories.UniversityRepo;

@Service
public class UniversityServices {
	@Autowired
	private UniversityRepo universityRepo;

	/* METHODS TO INTERACT WITH REPOSITORY */
	
//	Add a university
	public University createUniversity (University newUniversity) {
		return universityRepo.save(newUniversity);
	}
	
//	Get all universities
	public List<University> getAllUniversities() {
		return universityRepo.findAll();
	}
	
//	Get all universities in reverse alphabetical order
	public List<University> getAllUniversitiesReversedOrderName() {
		return universityRepo.findAllByOrderByNameDesc();
	}
	
	
//	Get one university
	public University getOneUniversity (Long id) {
		Optional<University> optionalUniversity = universityRepo.findById(id);
		
		/* Use these lines*/
//		if(optionalUniversity.isPresent()) {
//			return optionalUniversity.get();
//		}
//		else return null;
		
		/* or*/
		return optionalUniversity.orElseGet(() -> null);
		
	}
	
//	Update/edit university
	public University updateUniversity(University changedUniversity) {
		return universityRepo.save(changedUniversity);
	}
	
//	Delete a university
	public void deleteUniversity(Long id) {
		universityRepo.deleteById(id);
	}
}


