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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Truck {

	@Id
	@GeneratedValue

	private Long id;
	// Mileage is the total number of miles each truck has. The odometer reported
	// miles.
	@Column(precision=10, scale=2)
	private BigDecimal mileage;
	// The manufacterer of the vehicle. For example, Freightliner, International,
	// Peterbuilt.
	private String make;
	// Model of truck. For example, Cascadia. Make/Model would be
	// Freightliner/Cascadia
	private String model;
	// Year the truck was made.
	private String year;
	// Serial number of the truck.
	private String vIn;
	// license plate number of truck.
	private String plateNumber;
	// what the truck is supposed to physically run daily. The "X" run, where "X" is
	// string the user inputs..
	private String actualRun;
	// truck number
	private String truckNumber;
	// FedEx Assignment
	@OneToOne
	private FedExAssignment fedExAssignment;
	// trips truck has been on
	@JsonIgnore
	@OneToMany(mappedBy = "truck")
	private Collection<Trip> trips = new HashSet<Trip>();
	// company
	@ManyToOne
	private Company company;
	@ManyToMany
	private Collection<FedExAssignment> fedExPastAssignments = new HashSet<>();
	// Trucks get a service every X number of miles. This number should be the
	// difference between the mileage at service and milesTillService
	@Column(precision=10, scale=2)
	private BigDecimal milesAtService;
	// This value is the same for the life of a truck. For example, a 2012
	// Freightliner Cascadia should have a service ever 50,000 miles
	@Column(precision=10, scale=2)
	private BigDecimal milesBetweenService;
	// Every truck needs a DOT inspection annually. This should be the date of last
	// DOT inspection.
	private LocalDate dotInspectionDate;

	@ManyToMany
	private Collection<FuelPurchase> fuelPurchase = new HashSet<>();

	public Truck() {

	}

	public Truck(String truckNumber, String mileage, String make, String model, String year, String vIn, String plateNumber,
			String actualRun, String milesAtService, String milesBetweenService, int dotYear, int dotMonth, int dotDay) {
		this.truckNumber = truckNumber;
		this.mileage = new BigDecimal(mileage);
		this.make = make;
		this.model = model;
		this.year = year;
		this.vIn = vIn;
		this.plateNumber = plateNumber;
		this.actualRun = actualRun;
		this.milesAtService = new BigDecimal(milesAtService);
		this.milesBetweenService = new BigDecimal(milesBetweenService);
		this.dotInspectionDate = LocalDate.of(dotYear, dotMonth, dotDay);
	}
	/////// This is how the calculations for miles until service will work.
	// miles until service = milesBetweenService - (mileage - mileage at service)

	public String getTruckNumber() {
		return truckNumber;
	}
	
	public Long getId() {
		return id;
	}

	public BigDecimal getMileage() {
		return mileage;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getYear() {
		return year;
	}

	public String getvIn() {
		return vIn;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public String getActualRun() {
		return actualRun;
	}

	public Collection<Trip> getTrips() {
		return trips;
	}

	public BigDecimal getMilesTillService() {
		return milesAtService;
	}

	public BigDecimal getMilesBetweenService() {
		return milesBetweenService;
	}

	public LocalDate getDotInspectionDate() {
		return dotInspectionDate;
	}

}
