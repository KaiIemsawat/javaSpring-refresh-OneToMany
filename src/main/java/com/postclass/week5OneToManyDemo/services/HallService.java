package com.postclass.week5OneToManyDemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postclass.week5OneToManyDemo.models.Hall;
import com.postclass.week5OneToManyDemo.repositories.HallRepo;

@Service
public class HallService {
	@Autowired
	private HallRepo hallRepo;
	
//	Add a hall
	public Hall createHall(Hall newHall) {
		return hallRepo.save(newHall);
	}
	
//	Get all halls
	public List<Hall> getAllHalls() {
		return hallRepo.findAll();
	}
	
//	Get all halls order by name DESC
	public List<Hall> getAllHallReversed() {
		return hallRepo.findAllByOrderByHallNameDesc();
	}
	
//	Get a hall by id
	public Hall getHallById(Long id) {
		Optional<Hall> optHall = hallRepo.findById(id);
		return optHall.orElseGet(()->null);
//		Works the same way as below code 
//		 if (optHall.isPresent()) {
//			 return optHall.get();
//		 }
//		 else {
//			 return null;
//		 }
	}
	
//	Update a hall
	public Hall updateHall(Hall changedHall) {
		return hallRepo.save(changedHall);
	}
	
//	Delete a hall
	public void deleteHall(Long id) {
		hallRepo.deleteById(id);
	}
}
