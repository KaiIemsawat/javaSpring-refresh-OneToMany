package com.postclass.week5OneToManyDemo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.postclass.week5OneToManyDemo.models.University;
import com.postclass.week5OneToManyDemo.services.UniversityServices;



@Controller
public class UniversityController {
	@Autowired
	private UniversityServices universityService;
	
	@GetMapping("/")
	public String homeRoute() {
		return "redirect:/universities";
	}
	
//	Page that display all universities
	@GetMapping("/universities")
	public String allUniversities(Model viewModel) {
		viewModel.addAttribute("universities", universityService.getAllUniversities());
		return "universities";
	}
	
//	Page that show a university
	@GetMapping("/universities/{id}")
	public String viewOneUniversity(Model viewModel, @PathVariable("id") Long id ) {
		viewModel.addAttribute("thisUniversity", universityService.getOneUniversity(id));
		return "viewOneUniversity";
	}
	
	
//	Page that display form for adding new university
	@GetMapping("/universities/new")
	public String newUniversityPage(@ModelAttribute("newUniversity") // <-- @ModelAttribute("thisName") thisName need to be same as in newUniversity.jsp file
	University thisUniversity ) {
		return "newUniversity";
	}
	
//	POST route that adds a university to database
	@PostMapping("/universities/new")
	public String addUniversityToDB(
			@Valid
			@ModelAttribute("newUniversity") University aNewUniversity, // <-- @ModelAttribute("thisName") thisName need to be same as in newUniversity.jsp file
			BindingResult result) { 
		if(result.hasErrors()) {
			return "newUniversity";
		}
		 // If error, return (stay) to form page
		universityService.createUniversity(aNewUniversity);
		return "redirect:/"; // If validation success
	}
	
//	Page that display edit form
	@GetMapping("/universities/{id}/edit")
	public String editUniversityPage(@PathVariable Long id, Model viewModel) { // GET method, can use Model viewModel not @ModelAttribute()
		viewModel.addAttribute("thisUniversity", universityService.getOneUniversity(id)); // <-- viewModel.addAttribute("thisName") thisName need to be same as in newUniversity.jsp file
		return "editUniversity";
	}
	
//	PUT request route to edit university
	@PutMapping("/universities/{id}/edit")
	public String editUniversity(
			@Valid
			@ModelAttribute("thisUniversity") University changeUniversity, // <-- @ModelAttribute("thisName") thisName need to be same as in newUniversity.jsp file
			BindingResult result, @PathVariable Long id) { 
		if(result.hasErrors()) {
			return "editUniversity";
		}
		 // If error, return (stay) to form page
		universityService.updateUniversity(changeUniversity);
		return "redirect:/"; // If validation success
	}
	
//	DELETE request
	
	@GetMapping("/universities/{id}/delete") // For hyperlink
	@DeleteMapping("/universities/{id}/delete") // For button in form
	public String deleteUniversity(@PathVariable("id") Long id) {
		universityService.deleteUniversity(id);
		return "redirect:/universities";
	}
}









