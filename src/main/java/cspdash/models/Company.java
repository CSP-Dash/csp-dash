package cspdash.models;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Company {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany
	private Collection<Employee> employees = new HashSet<>();

	@OneToMany(mappedBy = "company")
	private Collection<Truck> trucks = new HashSet<>();

	@OneToMany(mappedBy = "company")
	private Collection<FedExAssignment> fedExAssignments = new HashSet<>();

	private String entityId;

	private String stationNumber;

	private String stationName;

	private String contractId;

	private String contractName;

	private String authOfficerId;

	private String authOfficerName;

	private String auaId;

	private String address;

	@ManyToMany
	private Collection<FuelPurchase> fuelPurchase = new HashSet<>();

	public Company() {

	}

	public Company(String entityId, String stationNumber, String stationName, String contractId, String contractName,
			String authOfficerId, String authOfficerName, String auaId, String address) {

		this.entityId = entityId;
		this.stationNumber = stationNumber;
		this.stationName = stationName;
		this.contractId = contractId;
		this.contractName = contractName;
		this.authOfficerId = authOfficerId;
		this.authOfficerName = authOfficerName;
		this.auaId = auaId;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}

	public Collection<Truck> getTrucks() {
		return trucks;
	}

	public String getEntityId() {
		return entityId;
	}

	public String getStationNumber() {
		return stationNumber;
	}

	public String getStationName() {
		return stationName;
	}

	public String getContractId() {
		return contractId;
	}

	public String getContractName() {
		return contractName;
	}

	public String getAuthOfficerId() {
		return authOfficerId;
	}

	public String getAuthOfficerName() {
		return authOfficerName;
	}

	public String getAuaId() {
		return auaId;
	}

	public String getAddress() {
		return address;
	}

}
