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
public class FuelPurchase {

	@Id
	@GeneratedValue
	private Long id;
	private LocalDate date;
	private String ticketCheckNumber;
	private String truckNumber;
	private String truckStop;
	private String city;
	private String state;
	@Column(precision=10, scale=4)
	private BigDecimal gallonsQty;
	// gallonsCost = PUR $AMT on settlement
	@Column(precision=10, scale=4)
	private BigDecimal gallonsCost;
	@Column(precision=10, scale=4)
	private BigDecimal authChgbkArrears;
	@Column(precision=10, scale=4)
	private BigDecimal authChgbkRefund;
	@Column(precision=10, scale=4)
	private BigDecimal authChgbkNetAmt;
	@Column(precision=10, scale=4)
	private BigDecimal repairMiscAmount;

	@ManyToMany
	private Collection<Company> companies = new HashSet<>();
	@ManyToMany
	private Collection<Truck> trucks = new HashSet<>();

	public FuelPurchase() {

	}

	public FuelPurchase(int dateYear, int dateMonth, int dateDay, String ticketCheckNumber, String truckNumber, String truckStop, String city,
			String state, String gallonsQty, String gallonsCost, String authChgbkArrears, String authChgbkRefund,
			String authChgbkNetAmt, String repairMiscAmount) {
		this.date = LocalDate.of(dateYear, dateMonth, dateDay);
		this.ticketCheckNumber = ticketCheckNumber;
		this.truckNumber = truckNumber;
		this.truckStop = truckStop;
		this.city = city;
		this.state = state;
		this.gallonsQty = new BigDecimal(gallonsQty);
		this.gallonsCost = new BigDecimal(gallonsCost);
		this.authChgbkArrears = new BigDecimal(authChgbkArrears);
		this.authChgbkRefund = new BigDecimal(authChgbkRefund);
		this.authChgbkNetAmt = new BigDecimal(authChgbkNetAmt);
		this.repairMiscAmount = new BigDecimal(repairMiscAmount);
	}

	public Long getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getTicketCheckNumber() {
		return ticketCheckNumber;
	}

	public String getTruckNumber() {
		return truckNumber;
	}

	public String getTruckStop() {
		return truckStop;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public BigDecimal getGallonsQty() {
		return gallonsQty;
	}

	public BigDecimal getGallonsCost() {
		return gallonsCost;
	}

	public BigDecimal getAuthChgbkArrears() {
		return authChgbkArrears;
	}

	public BigDecimal getAuthChgbkRefund() {
		return authChgbkRefund;
	}

	public BigDecimal getAuthChgbkNetAmt() {
		return authChgbkNetAmt;
	}

	public BigDecimal getRepairMiscAmount() {
		return repairMiscAmount;
	}

}
