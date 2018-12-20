package org.wecancodeit.fleettracker.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Trip {

	@Id
	@GeneratedValue

	private Long id;

	// Number assigned by FedEx for trip from one hub to the next.
	private Long tripNumber;

	// Date truck arrives at final destination of trip.
	private LocalDate date;

	// Date of week ending
	private LocalDate weekEnding;

	// FedEx number code for hub that truck leaves from. Sometimes but not always
	// correlates to zip. For example, Grove City hub is 0432.
	private Long origin;

	// Same as above but it's the hub that truck is going to.
	private Long destination;

	// Zip code of hub.
	private Long zipCode;

	// Total miles from Origin to Destination.
	@Column(precision = 10, scale = 2)
	private BigDecimal milesQuantity;

	// Variable Mileage Rate. BASE $ rate paid per mile. Same from hub to hub.
	@Column(precision = 10, scale = 4)
	private BigDecimal vMr;

	// Mileage Plus- additional cents paid per mile. Varies from Hub to Hub.
	@Column(precision = 10, scale = 4)
	private BigDecimal mileagePlus;

	// $ amount. I've never seen it used, but since they might use it, we should at
	// least have a field to accept it.
	@Column(precision = 10, scale = 4)
	private BigDecimal premiums;

	// Fuel Subsidy. FedEx pays X number of cents per mile to help with the cost of
	// fuel.
	@Column(precision = 10, scale = 4)
	private BigDecimal fuel;

	// They do math on this, it's just the sum of the previous items. Total Rate =
	// VMR + Mileage Plus + Premiums + Fuel.
	@Column(precision = 10, scale = 4)
	private BigDecimal totalRate;

	// AMT = $ amount paid for miles driven. AMT = Miles Quantity * Total Rate.
	@Column(precision = 10, scale = 4)
	private BigDecimal aMt;

	// I've never seen this used, but supposedly you can do an emergency run and
	// they pay X dollars per package.
	private Long packages;

	// packages $amount
	private Long packageAmt;

	// Drop and Hook (D&H) is a flat rate paid to hook trailers up to a truck. It's
	// paid every time they have to connect or disconnect trailers.\
	@Column(precision = 10, scale = 4)
	private BigDecimal dropAndHook;

	// Some highways require paid tolls. This is a $ amount.
	@Column(precision = 10, scale = 4)
	private BigDecimal tolls;

	// This isn't often used, but on some runs they'll set a flat amount and pay
	// that instead of calculating anything per mile.
	@Column(precision = 10, scale = 4)
	private BigDecimal flatRate;

	// Gross amount is $AMT + Drop and Hook.
	@Column(precision = 10, scale = 4)
	private BigDecimal dailyGrossAmount;

	// FedEx ID for first driver.
	private String driverOne;

	// FedEx ID for second driver.
	private String driverTwo;

	// employee
	@ManyToMany
	private Collection<Employee> employees;

	// truck
	@ManyToOne
	private Truck truck;

	// vmr + mileage plus + premiums + fuel
	@Column(precision = 10, scale = 4)
	private BigDecimal calculatedTotalRate;

	// milesQuantity + totalRate
	@Column(precision = 10, scale = 4)
	private BigDecimal calculatedAMT;

	// amt + dropAndHook
	@Column(precision = 10, scale = 4)
	private BigDecimal calculatedDailyGrossAmount;

	public Trip() {

	}

	public Trip(int dateYear, int dateMonth, int dateDay, Long tripNumber, Long origin, Long destination, Long zipCode,
			String milesQuantity, String vMr, String mileagePlus, String premiums, String fuel, String totalRate,
			String aMt, Long packages, Long packageAmt, String dropAndHook, String tolls, String flatRate,
			String dailyGrossAmount, String driverOne, String driverTwo, Truck truck) {

		this.tripNumber = tripNumber;
		this.date = LocalDate.of(dateYear + 2000, dateMonth, dateDay);
		this.weekEnding = calculateWeekEnding(this.date);
		this.origin = origin;
		this.destination = destination;
		this.zipCode = zipCode;
		this.milesQuantity = new BigDecimal(milesQuantity);
		this.vMr = new BigDecimal(vMr);
		this.mileagePlus = new BigDecimal(mileagePlus);
		this.premiums = new BigDecimal(premiums);
		this.fuel = new BigDecimal(fuel);
		this.totalRate = new BigDecimal(totalRate);
		this.aMt = new BigDecimal(aMt);
		this.packages = packages;
		this.packageAmt = packageAmt;
		this.dropAndHook = new BigDecimal(dropAndHook);
		this.tolls = new BigDecimal(tolls);
		this.flatRate = new BigDecimal(flatRate);
		this.dailyGrossAmount = new BigDecimal(dailyGrossAmount);
		this.driverOne = driverOne;
		this.driverTwo = driverTwo;
		this.truck = truck;
		this.calculatedTotalRate = this.vMr.add(this.mileagePlus).add(this.premiums).add(this.fuel);
		this.calculatedAMT = this.milesQuantity.multiply(this.totalRate).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.calculatedDailyGrossAmount = this.aMt.add(this.dropAndHook);
	}

	public Long getId() {
		return id;
	}

	public Long getTripNumber() {
		return tripNumber;
	}

	public LocalDate getDate() {
		return date;
	}

	public Long getOrigin() {
		return origin;
	}

	public Long getDestination() {
		return destination;
	}

	public Long getZipCode() {
		return zipCode;
	}

	public BigDecimal getMilesQuantity() {
		return milesQuantity;
	}

	public BigDecimal getvMr() {
		return vMr;
	}

	public BigDecimal getMileagePlus() {
		return mileagePlus;
	}

	public BigDecimal getPremiums() {
		return premiums;
	}

	public BigDecimal getFuel() {
		return fuel;
	}

	public BigDecimal getTotalRate() {
		return totalRate;
	}

	public BigDecimal getaMt() {
		return aMt;
	}

	public Long getPackages() {
		return packages;
	}

	public Long getPackageAmt() {
		return packageAmt;
	}

	public BigDecimal getDropAndHook() {
		return dropAndHook;
	}

	public BigDecimal getTolls() {
		return tolls;
	}

	public BigDecimal getFlatRate() {
		return flatRate;
	}

	public BigDecimal getDailyGrossAmount() {
		return dailyGrossAmount;
	}

	public String getDriverOne() {
		return driverOne;
	}

	public String getDriverTwo() {
		return driverTwo;
	}

	public BigDecimal getCalculatedTotalRate() {
		return calculatedTotalRate;
	}

	public BigDecimal getCalculatedAMT() {
		return calculatedAMT;
	}

	public BigDecimal getCalculatedDailyGrossAmount() {
		return calculatedDailyGrossAmount;
	}

	public LocalDate getWeekEnding() {
		return weekEnding;
	}

	public Truck getTruck() {
		return truck;
	}

	// other methods

	public LocalDate calculateWeekEnding(LocalDate date) {
		String day = date.getDayOfWeek().name();
		int daysAdded = 0;
		switch(day){
		case "MONDAY":
			daysAdded = 4;
			break;
		case "TUESDAY": 
			daysAdded = 3;
			break;
		case "WEDNESDAY": 
			daysAdded = 2;
			break;
		case "THURSDAY": 
			daysAdded = 1;
			break;
		case "FRIDAY": 
			break;
		case "SATURDAY": 
			daysAdded = 6;
			break;
		case "SUNDAY": 
			daysAdded = 5;
			break;
		default:
			return LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
		}
		
		int monthLength = date.getMonth().length(date.isLeapYear());
		
		if(date.getDayOfMonth() + daysAdded > monthLength) {
			if(date.getMonthValue()==12) {
				return LocalDate.of(date.getYear() + 1, 1, (date.getDayOfMonth() + daysAdded) - monthLength);
			}
			return LocalDate.of(date.getYear(), date.getMonthValue() + 1, (date.getDayOfMonth() + daysAdded) - monthLength);
		}
		
		return LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth() + daysAdded);
	}

}
