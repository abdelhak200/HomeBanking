package ch.home.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.home.bank.entity.User;
import ch.home.bank.repository.UserRepository;

@Service
@Transactional
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

	public List<User> findById(Integer id) {
		List<User> list = new ArrayList<User>();
		list.add(userRepository.findById(id).orElse(new User()));
		return list;
	}

	public User updateUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
	}

	public List<User> findByName(String firstName) {
		return (List<User>) userRepository.findByFirstName(firstName);
	}

}
