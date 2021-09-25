package ch.home.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.home.bank.entity.User;
import ch.home.bank.repository.UserRepository;

@Service
public class ServiceUser {

	@Autowired
	private UserRepository userRepository;

	public ServiceUser() {
	}

	public List<User> getAll() {
		return (List<User>) userRepository.findAll();
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public User getById(int id) {
		// return list.stream().filter(uti
		// ->nom.equals(uti.getNom())).findFirst().orElse(new User());
		return userRepository.findById(id).orElse(new User());
	}

	public void updateUser(User user) {
		userRepository.save(user);
	}

}
