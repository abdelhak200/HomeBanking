package ch.home.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.home.bank.entity.User;
import ch.home.bank.service.ServiceUser;

@RestController
@RequestMapping("/users")
public class ControllerUser {
	
	@Autowired
	private ServiceUser serviceUser;
	
	@GetMapping
	public List<User> getAll(){
		return serviceUser.getAll();
	}
	
	@PostMapping
	public void addUser(@RequestBody User user) {
		 serviceUser.addUser(user);
	}
	
	@GetMapping("/{id}")
	public User getByID(@PathVariable(required = false, value="id") Integer id){
		return serviceUser.getById(id);
	}
	
	@PatchMapping("/{id}")
	public void patch(@RequestBody User user, @PathVariable(required = true, value="id") int id) {
		User userPatched = serviceUser.getById(id);
		userPatched.setNom(user.getNom());
		userPatched.setPrenom(user.getPrenom());
		userPatched.setDate_de_naissance(user.getDate_de_naissance());
		userPatched.setDate_debut_contrat(user.getDate_debut_contrat());
		userPatched.setDate_fin_contrat(user.getDate_debut_contrat());
		
		 serviceUser.updateUser(userPatched);
	}
}
