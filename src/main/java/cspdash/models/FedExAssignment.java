package cspdash.models;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class FedExAssignment {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Company company;
	@OneToOne
	private Truck truck;
	@ManyToMany
	private Collection<Truck> pastTrucks = new HashSet<>();
	@Column(precision=10, scale=4)
	private BigDecimal servicePercentage;
	@Column(precision=10, scale=4)
	private BigDecimal availabilityPercentage;
	private Long points;

	// declines remaining is calculated and not statically given.
	// private Long declinesRemaining;

	// \/\/\/\/\/\/\/\/\/\
	// Getters
	// \/\/\/\/\/\/\/\/\/\

	public Long getId() {
		return id;
	}

	public Company getCompany() {
		return company;
	}

	public Truck getTruck() {
		return truck;
	}

	public Collection<Truck> getPastTrucks() {
		return pastTrucks;
	}

	public BigDecimal getServicePercentage() {
		return servicePercentage;
	}

	public BigDecimal getAvailabilityPercentage() {
		return availabilityPercentage;
	}

	public Long getPoints() {
		return points;
	}

	// \/\/\/\/\/\/\/\/\/\
	// Constructors
	// \/\/\/\/\/\/\/\/\/\

	public FedExAssignment() {

	}

	public FedExAssignment(Company company, Truck truck, String servicePercentage, String availabilityPercentage,
			Long points) {
		this.company = company;
		this.truck = truck;
		this.servicePercentage = new BigDecimal(servicePercentage);
		this.availabilityPercentage = new BigDecimal(availabilityPercentage);
		this.points = points;
	}

}
