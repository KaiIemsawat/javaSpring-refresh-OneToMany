package com.postclass.week5OneToManyDemo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.postclass.week5OneToManyDemo.models.Hall;
import com.postclass.week5OneToManyDemo.services.HallService;
import com.postclass.week5OneToManyDemo.services.UniversityServices;

@Controller
public class HallController {
	/* ===== SERVICES ===== */
	@Autowired
	private HallService hallServ;
	@Autowired
	private UniversityServices universityServ;
	
	/* ===== RENDER PAGE ROUTES ===== */
	@GetMapping("/halls")
	public String allHallPage(Model viewModel) {
		viewModel.addAttribute("allHalls", hallServ.getAllHalls());
		return "halls";
	}
	
//	In @GetMapping, @ModelAttribute -> Needed when adding not editing
	@GetMapping("/halls/new")
	public String newHallPage(
			@ModelAttribute("newHall") Hall newHall // @ModelAttribute("thisName") <-- this name needs to match to what declare in JSP file
			, Model viewModel
			) { 
		viewModel.addAttribute("universities", universityServ.getAllUniversities()); // To get list of universities for drop down menu
		return "newHall";
	}
	
	@GetMapping("/halls/{id}")
	public String viewOneHallPage(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("thisHall", hallServ.getHallById(id));
		return "viewOneHall";
	}
	
//	In @GetMapping, @ModelAttribute -> Needed when adding not editing
	@GetMapping("/halls/{id}/edit")
	public String editHallPage(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("editHall", hallServ.getHallById(id));
		viewModel.addAttribute("universities", universityServ.getAllUniversities()); // To get list of universities for drop down menu
		return "editHall";
	}
	
	/* ===== PROCESS PAGE ROUTES ===== */
//	Add hall to database
	@PostMapping("/halls/new")
	public String addHall(
			@Valid @ModelAttribute("newHall") Hall newHall // @ModelAttribute("thisName") <-- this name needs to match to what declare in JSP file
			, BindingResult result
			, Model viewModel
			) {
		if(result.hasErrors()) {
			viewModel.addAttribute("universities", universityServ.getAllUniversities()); // To get list of universities for drop down menu
			return "newHall";
		}
		hallServ.createHall(newHall);
		return "redirect:/halls";
	}
	
//	Edit a hall in database
	@PutMapping("/halls/{id}/edit")
	public String editHall(
			@PathVariable("id") Long id
			, @Valid @ModelAttribute("editHall") Hall editHall // @ModelAttribute("thisName") <-- this name needs to match to what declare in JSP file
			, BindingResult result
			, Model viewModel
			) {
		if(result.hasErrors()) {
			viewModel.addAttribute("universities", universityServ.getAllUniversities()); // To get list of universities for drop down menu
			return "editHall";
		}
		hallServ.updateHall(editHall);
		return "redirect:/halls/"+id;
	}
	
//	Delete a hall from database
	@RequestMapping(value = "/halls/{id}/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteHall(@PathVariable("id") Long id) {
		hallServ.deleteHall(id);
		return "redirect:/halls";
	}
	
}
