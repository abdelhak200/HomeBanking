package ch.home.bank.entity;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="USERS")
public class User implements Serializable	{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static DateTimeFormatter FORMAT_DATE_HOUR = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
	private static DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
	private Integer id;
    @Column(name = "FIRST_NAME")
	private String  firstName;
    @Column(name = "SECOND_NAME")
	private String secondName;
    @Column(name = "BIRTH_DATE")
	private String birthDay;
    @Column(name = "START_DATE")
	private String startDate;
    @Column(name = "END_DATE")
	private String endDate;
	
	public User() {}

	public User(String firstName, String secondName, String birthDay, String startDate, String endDate) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.birthDay = birthDay;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
