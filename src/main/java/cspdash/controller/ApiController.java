package cspdash.controller;

import java.util.Collection;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cspdash.models.Company;
import cspdash.models.Employee;
import cspdash.models.FedExAssignment;
import cspdash.models.FuelPurchase;
import cspdash.models.Trip;
import cspdash.models.Truck;
import cspdash.repositories.CompanyRepository;
import cspdash.repositories.EmployeeRepository;
import cspdash.repositories.FedExAssignmentRepository;
import cspdash.repositories.FuelPurchaseRepository;
import cspdash.repositories.TripRepository;
import cspdash.repositories.TruckRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private TruckRepository truckRepo;

	@Autowired
	private TripRepository tripRepo;

	@Autowired
	private EmployeeRepository employeeRepo;

	@Autowired
	private CompanyRepository companyRepo;

	@Autowired
	private FedExAssignmentRepository assignmentRepo;

	@Autowired
	private FuelPurchaseRepository fuelPurchaseRepo;

	@GetMapping("/trucks")
	public Iterable<Truck> getTrucks() {
		return truckRepo.findAll();
	}

	@GetMapping("/trucks/{id}")
	public Truck getTruck(@PathVariable(value = "id") Long id) {
		return truckRepo.findById(id).get();
	}

	@GetMapping("/trips")
	public Iterable<Trip> getTrips() {
		return tripRepo.findAll();
	}

	@GetMapping("/trips/{id}")
	public Trip getTrip(@PathVariable(value = "id") Long id) {
		return tripRepo.findById(id).get();

	}

	@PostMapping("/add/trips")
	public Collection<Trip> addTrip(@RequestBody String body) throws JSONException {
		System.out.println(body);
		JSONObject json = new JSONObject(body);

		String date = json.getString("DATE");
		int dateYear = Integer.parseInt(date.split("-")[2]);
		// make it recognize Nov as 11, etc.
		int dateMonth = Integer.parseInt(date.split("-")[1]);
		int dateDay = Integer.parseInt(date.split("-")[0]);
		Long tripNumber = json.getLong("TRIP #");
		Long origin = json.getLong("LEG ORG");
		Long destination = json.getLong("LEG DEST");
		Long zipCode = json.getLong("ZIP/POSTAL");
		String milesQuantity = json.getString("MILES QTY");
		String vMr = json.getString("VMR RATE");
		String mileagePlus = json.getString("MILEAGE PLUS");
		String premiums = json.getString("PREMIUMS");
		String fuel = json.getString("FUEL");
		String totalRate = json.getString("TOTAL RATE");
		String aMt = json.getString("$ AMT");
		Long packages = json.getLong("# PKGS");
		Long packageAmt = json.getLong("PKG $ AMT"); // Double $ AMT variables??
		String dropAndHook = json.getString("D AND H");
		String tolls = json.getString("TOLLS");
		String flatRate = json.getString("FLAT RATE");
		String dailyGrossAmount = json.getString("DAILY GROSS $ AMT");
		String driverOne = json.getString("DRIVER #1");
		String driverTwo = json.getString("DRIVER #2");

		Optional<Truck> optionalTruck = truckRepo.findByTruckNumber(json.getString("TRUCK"));
		Truck truck;

		if (optionalTruck.isPresent()) {
			truck = optionalTruck.get();
		} else {
			// fix this
			throw new Error("not a truck!!!!!!");
		}

		tripRepo.save(new Trip(dateYear, dateMonth, dateDay, tripNumber, origin, destination, zipCode, milesQuantity,
				vMr, mileagePlus, premiums, fuel, totalRate, aMt, packages, packageAmt, dropAndHook, tolls, flatRate,
				dailyGrossAmount, driverOne, driverTwo, truck));
		System.out.println(tripRepo.findAll());
		return (Collection<Trip>) tripRepo.findAll();
	}

	@GetMapping("/employees")
	public Iterable<Employee> getEmployees() {
		return employeeRepo.findAll();
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable(value = "id") Long id) {
		return employeeRepo.findById(id).get();

	}

	@GetMapping("/companies")
	public Iterable<Company> getCompanies() {
		return companyRepo.findAll();
	}

	@GetMapping("/companies/{id}")
	public Company getCompany(@PathVariable(value = "id") Long id) {
		return companyRepo.findById(id).get();

	}

	@GetMapping("/fedexassignments")
	public Iterable<FedExAssignment> getFedExAssignments() {
		return assignmentRepo.findAll();
	}

	@GetMapping("/fedexassignments/{id}")
	public FedExAssignment getFedExAssignment(@PathVariable(value = "id") Long id) {
		return assignmentRepo.findById(id).get();

	}

	@GetMapping("/fuelpurchases")
	public Iterable<FuelPurchase> getFuelPurchases() {
		return fuelPurchaseRepo.findAll();
	}

	@GetMapping("/fuelpurchases/{id}")
	public FuelPurchase getFuelPurchase(@PathVariable(value = "id") Long id) {
		return fuelPurchaseRepo.findById(id).get();

	}

}
