package ch.home.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin(origins = "http://localhost:4200")
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
	
	@DeleteMapping
	public void deleteUserById(@PathVariable(required = false, value="id") Integer id) {
		 serviceUser.deleteUserById(id);
	}
	
	@GetMapping("/{id}")
	public User getByID(@PathVariable(required = false, value="id") Integer id){
		return serviceUser.getById(id);
	}
	
	@GetMapping("/{name}")
	public List<User> getByNmae(@PathVariable(required = false, value="name") String name){
		return serviceUser.getByName(name);
	}
	
	@PatchMapping("/{id}")
	public void patch(@RequestBody User user, @PathVariable(required = true, value="id") int id) {
		User userPatched = serviceUser.getById(id);
		userPatched.setFirstName(user.getFirstName());
		userPatched.setSecondName(user.getSecondName());
		userPatched.setBirthDay(user.getBirthDay());
		userPatched.setStartDate(user.getStartDate());
		userPatched.setEndDate(user.getEndDate());
		
		 serviceUser.updateUser(userPatched);
	}
}
