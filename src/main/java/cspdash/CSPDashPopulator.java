package org.wecancodeit.fleettracker;

import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.fleettracker.models.Company;
import org.wecancodeit.fleettracker.models.Employee;
import org.wecancodeit.fleettracker.models.FedExAssignment;
import org.wecancodeit.fleettracker.models.FuelPurchase;
import org.wecancodeit.fleettracker.models.Trip;
import org.wecancodeit.fleettracker.models.Truck;
import org.wecancodeit.fleettracker.repositories.CompanyRepository;
import org.wecancodeit.fleettracker.repositories.EmployeeRepository;
import org.wecancodeit.fleettracker.repositories.FedExAssignmentRepository;
import org.wecancodeit.fleettracker.repositories.FuelPurchaseRepository;
import org.wecancodeit.fleettracker.repositories.TripRepository;
import org.wecancodeit.fleettracker.repositories.TruckRepository;

@Service
public class FleetTrackerPopulator implements CommandLineRunner {

	@Resource
	CompanyRepository companyRepo;

	@Resource
	EmployeeRepository employeeRepo;

	@Resource
	FedExAssignmentRepository fedExAssignmentRepo;

	@Resource
	FuelPurchaseRepository fuelPurchaseRepo;

	@Resource
	TripRepository tripRepo;

	@Resource
	TruckRepository truckRepo;

	@Override
	public void run(String... args) throws Exception {

//		Company(String , String , String , String , String , String , String , String , String , String )
//		Company( companyName,  entityId,  stationNumber,  stationName,  contractId,  contractName,  authOfficerId,  authOfficerName,  auaId,  address)		

		Company companyOne = new Company("V0010658", "00432", "Columbus - HUB", "C7518290", "Mitos Express, Inc.",
				"7513236", "Lois Brewster", "122832", "123 Paper St. Pickerington, Ohio");
		Company companyTwo = new Company("V0010338", "00432", "Columbus - HUB", "C12345", "Brewster Motor Express",
				"7040238", "Steve Brewster", "123456", "123 Paper St. Pickerington, Ohio");
		createCompanyList(new Company[] { companyOne, companyTwo }).forEach(this::saveCompanyToRepo);

//		Employee(float , String , String , String , String , String ,String , String , String , String , String ,String , String , Float , Float , Float ,Float )
//		Employee( miles,  ssn,  fedexId,  dateOfBirth,  phoneNumber,  hireDate, sixtyDays,  licenseNumber,  licenseState,  licenseExp,  dotPhysicalExp, address,  email,  soloPayrate,  teamPayrate,  trainerPayrate, studentPayrate)

		createEmployeeList(new Employee[] {
				new Employee("John", "Peter", "Doe", "875000", "270-55-5555", "7020234", 1922, 10, 28, "614-666-6666",
						2016, 10, 1, "RU636222", "Ohio", 2020, 10, 28, 2019, 10, 1, "420 Paper Street",
						"horseFan@ghosts.pizza", "0.56", "0.60", "0.65", "0.40"),
				new Employee("Doug", "", "Hamsammich", "9925000", "310-55-5555", "702333", 1991, 1, 1, "614-666-6666",
						2016, 10, 1, "RU636222", "Ohio", 2020, 10, 28, 2019, 5, 4,
						"1640 Riverside Drive, Hill Valley, California", "PeterBuiltGuy@trucker.net", "0.56", "0.60",
						"0.65", "0.40") }).forEach(this::saveEmployeeToRepo);

//		FedExAssignment(Company , Truck , Float , Float ,Long )
//		FedExAssignment( company,  truck,  servicePercentage,  availabilityPercentage, points)

		Truck truckOne = new Truck("123", "500000.5492", "Freightliner", "Cascadia", "2019", "3AKJHJL12345", "EFP123",
				"Rialto", "400000", "50000", 2018, 5, 4);
		Truck truckTwo = new Truck("321", "666666", "Freightliner", "Cascadia", "2012", "6ASS5JL12345", "EFP456",
				"Rialto", "300000", "55000", 2018, 7, 8);
		createTruckList(new Truck[] { truckOne, truckTwo,
				new Truck("456", "420420", "International", "LT", "2016", "ASDFGHJKL345", "EFP789", "Rialto", "400000",
						"45000", 2018, 6, 12),
				new Truck("654", "123456", "Freightliner", "Cascadia", "2012", "6ASS5JL99945", "EFP987", "Rialto",
						"300000", "55000", 2018, 9, 20) }).forEach(this::saveTruckToRepo);

		createFedExAssignment(new FedExAssignment[] { new FedExAssignment(companyOne, truckOne, "1.0", "98.2", 1324L),
				new FedExAssignment(companyTwo, truckTwo, "1.0", "98.2", 1324L) })
						.forEach(this::saveFedExAssignmentToRepo);

//		FuelPurchase(String , String , String , String , String , String , Float , Float , Float , Float , Float , Float )
//		FuelPurchase( date,  ticketCheckNumber,  truckNumber,  truckStop,  city,  state,  gallonsQty,  gallonsCost,  authChgbkArrears,  authChgbkRefund,  authChgbkNetAmt,  repairMiscAmount)

		createFuelPurchaseList(new FuelPurchase[] {
				new FuelPurchase(2018, 12, 15, "6789", "136512", "BP", "Denver", "Colorado", "310", "999", "0", "0",
						"0", "12"),
				new FuelPurchase(2018, 11, 3, "12345", "136989", "Pilot Flying J", "Columbus", "Ohio", "368", "1104",
						"0", "0", "0", "12") }).forEach(this::saveFuelPurchaseToRepo);

//		Truck(Float , String , String , String , String , String , String , Long , Long , String )
//		Truck( mileage,  make,  model,  year,  vIn,  ,  actualRun, milesAtService,  milesBetweenService,  dotInspectionDate)

//		Trip(String, Long , Long , Long , Long , Float ,Float , Float , Float , Float , Float , Float , Long , Long, Float , Float , Float , Float , String , String 
//		Trip( date,  tripNumber,  origin,  destination,  zipCode,  milesQuantity, vMr,  mileagePlus,  premiums,  fuel,  totalRate,  aMt,  packages, packagesAmt, dropAndHook,  tolls,  flatRate,  dailyGrossAmount,  driverOne,  driverTwo)	

		createTripList(new Trip[] {
				new Trip(18, 11, 9, 118221163L, 432L, 89L, 43123L, "528", "1.305", "0.095", "0", "0.287", "1.687",
						"890.74", 0L, 0L, "13", "0", "0", "903.74", "7297759", "", truckTwo),
				new Trip(18, 11, 6, 118256513L, 89L, 5087L, 8832L, "5", "2.816", "0.095", "0", "0.287", "3.198", "16",
						0L, 0L, "9", "0", "0", "25", "7297759", "", truckOne),
				new Trip(18, 10, 31, 118257154L, 5087L, 5431L, 8837L, "527", "1.305", "0.095", "0", "0.287", "1.687",
						"889.06", 0L, 0L, "9", "0", "0", "898.06", "7297759", "", truckOne) })
								.forEach(this::saveTripToRepo);

	}

	private ArrayList<FuelPurchase> createFuelPurchaseList(FuelPurchase[] fuelPurchase) {
		return new ArrayList<>(Arrays.asList(fuelPurchase));
	}

	private void saveFuelPurchaseToRepo(FuelPurchase fuelPurchase) {
		fuelPurchaseRepo.save(fuelPurchase);
	}

	private ArrayList<Company> createCompanyList(Company[] company) {
		return new ArrayList<>(Arrays.asList(company));
	}

	private void saveCompanyToRepo(Company company) {
		companyRepo.save(company);
	}

	private ArrayList<Employee> createEmployeeList(Employee[] employee) {
		return new ArrayList<>(Arrays.asList(employee));
	}

	private void saveEmployeeToRepo(Employee employee) {
		employeeRepo.save(employee);
	}

	private ArrayList<FedExAssignment> createFedExAssignment(FedExAssignment[] fedExAssignment) {
		return new ArrayList<>(Arrays.asList(fedExAssignment));
	}

	private void saveFedExAssignmentToRepo(FedExAssignment fedExAssignment) {
		fedExAssignmentRepo.save(fedExAssignment);
	}

	private ArrayList<Trip> createTripList(Trip[] trips) {
		return new ArrayList<>(Arrays.asList(trips));
	}

	private void saveTripToRepo(Trip trip) {
		tripRepo.save(trip);
	}

	private ArrayList<Truck> createTruckList(Truck[] trucks) {
		return new ArrayList<>(Arrays.asList(trucks));
	}

	private void saveTruckToRepo(Truck truck) {
		truckRepo.save(truck);
	}

}
