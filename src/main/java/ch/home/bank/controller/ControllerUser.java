package ch.home.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<User> addUser(@Validated @RequestBody User user) {
		 User savedUser = serviceUser.addUser(user);
			return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable(required = false, value="id") Integer id) {
		 serviceUser.deleteUserById(id);
	}
	
	@GetMapping("/{id}")
	public User getByID(@PathVariable(required = false, value="id") Integer id){
		return serviceUser.findById(id);
	}
	
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Integer Id,
         @Validated @RequestBody User user) {
    	User updateUser = serviceUser.updateUser(user);
    	return new ResponseEntity<User>(updateUser, HttpStatus.CREATED);
    }
	
	@GetMapping("/param{name}")
	public List<User> getByNmae(@RequestParam(required = false) String name){
		return serviceUser.findByName(name);
	}
	
	@PatchMapping("/{id}")
	public void patch(@RequestBody User user, @PathVariable(required = true, value="id") int id) {
		User userPatched = serviceUser.findById(id);
		userPatched.setFirstName(user.getFirstName());
		userPatched.setSecondName(user.getSecondName());
		userPatched.setBirthDay(user.getBirthDay());
		userPatched.setStartDate(user.getStartDate());
		userPatched.setEndDate(user.getEndDate());
		
		 serviceUser.updateUser(userPatched);
	}
}
