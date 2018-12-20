package org.wecancodeit.fleettracker.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private long id;

	@Column(precision = 10, scale = 2)
	private BigDecimal miles;

	@ManyToMany
	private Collection<Company> companies = new HashSet<>();

	@ManyToMany
	private Collection<Trip> trips = new HashSet<>();

	private String fName;

	private String mName;

	private String lName;

	private String ssn;

	private String fedexId;

	private LocalDate dateOfBirth;

	private String phoneNumber;

	private LocalDate hireDate;

	private String licenseNumber;

	private String licenseState;

	private LocalDate licenseExp;

	private LocalDate dotPhysicalExp;

	private String address;

//	private Collection<String> accidents = new HashSet<>();

	private String email;

	@Column(precision = 10, scale = 4)
	private BigDecimal soloPayrate;

	@Column(precision = 10, scale = 4)
	private BigDecimal teamPayrate;

	@Column(precision = 10, scale = 4)
	private BigDecimal trainerPayrate;

	@Column(precision = 10, scale = 4)
	private BigDecimal studentPayrate;

	public Employee() {

	}

	public Employee(String fName, String mName, String lName, String miles, String ssn, String fedexId, int dobYear,
			int dobMonth, int dobDay, String phoneNumber, int hireYear, int hireMonth, int hireDay,
			String licenseNumber, String licenseState, int licenseExpYear, int licenseExpMonth, int licenseExpDay,
			int dotExpYear, int dotExpMonth, int dotExpDay, String address, String email, String soloPayrate,
			String teamPayrate, String trainerPayrate, String studentPayrate) {

		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
		this.miles = new BigDecimal(miles);
		this.ssn = ssn;
		this.fedexId = fedexId;
		this.dateOfBirth = LocalDate.of(dobYear, dobMonth, dobDay);
		this.phoneNumber = phoneNumber;
		this.hireDate = LocalDate.of(hireYear, hireMonth, hireDay);
		this.licenseNumber = licenseNumber;
		this.licenseState = licenseState;
		this.licenseExp = LocalDate.of(licenseExpYear, licenseExpMonth, licenseExpDay);
		this.dotPhysicalExp = LocalDate.of(dotExpYear, dotExpMonth, dotExpDay);
		this.address = address;
		this.email = email;
		this.soloPayrate = new BigDecimal(soloPayrate);
		this.teamPayrate = new BigDecimal(teamPayrate);
		this.trainerPayrate = new BigDecimal(trainerPayrate);
		this.studentPayrate = new BigDecimal(studentPayrate);
	}

	public long getId() {
		return id;
	}

	public String getfName() {
		return fName;
	}

	public String getmName() {
		return mName;
	}

	public String getlName() {
		return lName;
	}

	public BigDecimal getMiles() {
		return miles;
	}

	public Collection<Company> getCompanies() {
		return companies;
	}

	public Collection<Trip> getTrips() {
		return trips;
	}

	public String getSsn() {
		return ssn;
	}

	public String getFedexId() {
		return fedexId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public String getLicenseState() {
		return licenseState;
	}

	public LocalDate getLicenseExp() {
		return licenseExp;
	}

	public LocalDate getDotPhysicalExp() {
		return dotPhysicalExp;
	}

	public String getAddress() {
		return address;
	}

//	public Collection<String> getAccidents() {
//		return accidents;
//	}

	public String getEmail() {
		return email;
	}

	public BigDecimal getSoloPayrate() {
		return soloPayrate;
	}

	public BigDecimal getTeamPayrate() {
		return teamPayrate;
	}

	public BigDecimal getTrainerPayrate() {
		return trainerPayrate;
	}

	public BigDecimal getStudentPayrate() {
		return studentPayrate;
	}
	
	

}
