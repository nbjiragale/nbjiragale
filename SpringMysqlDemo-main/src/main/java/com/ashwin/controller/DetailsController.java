package com.ashwin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashwin.accessingdatamysql.Details;
import com.ashwin.accessingdatamysql.DetailsRepository;


@RestController
public class DetailsController {
	
	@Autowired
	private DetailsRepository detailsRepository;
	
	
	@GetMapping("/api/details/{id}")
	public Optional<Details> getUser(@PathVariable int id ) {
		return detailsRepository.findById(id);
	}
	
	@PostMapping("/api/details")
	public void addNewDetails(@PathVariable Details details) {
		detailsRepository.save(details);
		
	}
	
	@GetMapping("/api/details")
	public List<Details> getUsers(){
		return (List<Details>)detailsRepository.findAll();
	}
	
	@GetMapping("/api/details/del/{id}")
	public String delUser(@PathVariable int id) {
		detailsRepository.deleteById(id);
		return "Successfully Deleted the details of id " + id;
	}
	
	
	
}
