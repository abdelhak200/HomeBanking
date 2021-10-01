package ch.home.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ch.home.bank.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT * FROM USERS WHERE FIRSTNAME like '%?1%' OR SECONDNAME like '%?1%'")
    List<User> findByName(String name);
}
