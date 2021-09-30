package ch.home.bank.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="USERS")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String  firstName;
	private String secondName;
	private LocalDate birthDay;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	public User() {}

	public User(String firstName, String secondName, LocalDate birthDay, LocalDateTime startDate,
			LocalDateTime endDate) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.birthDay = birthDay;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	
}
