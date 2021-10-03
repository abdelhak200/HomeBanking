package ch.home.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ch.home.bank.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value ="SELECT * FROM USERS WHERE FIRST_NAME like %?1% OR SECOND_NAME like %?1% ", 
			  nativeQuery = true)
    List<User> findByName(String name);
}
