package ch.home.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.home.bank.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
 
}
