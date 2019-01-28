import React, { Component } from 'react';
import {render} from 'react-dom';
import Trucks from './components/Trucks';
import Trips from './components/Trips';
import Employees from './components/Employees';
import FuelPurchases from './components/FuelPurchases';
import FedExAssignments from './components/FedExAssignments';
import Companies from './components/Companies';
import Calculations from './components/Calculations';
import Dashboard from './components/Dashboard';
import Uploader from './components/Uploader';
import logo from './cspdashlogo.png';
import { Collapse, Navbar, NavbarToggler,ButtonGroup, NavbarBrand, Nav,Button, NavItem, NavLink } from 'reactstrap';


class App extends Component {
    constructor() {
        super()
        this.state = {
            mobileOpen: false,
            trucks: [],
            trips: [],
            employees: [],
            fuelPurchases: [],
            fedExAssignments: [],
            companies: [],
            currentView: 'dash',
            collapsed: true

        }
        this.toggleNavbar = this.toggleNavbar.bind(this)
    }

    getCompanies() {
        fetch('/api/companies').then(res => res.json())
            .then(data => {
                console.log(data);
                this.setState({ companies: data })
            })
    }

    getFedExAssignments() {
        fetch('/api/fedexassignments').then(res => res.json())
            .then(data => {
                console.log(data);
                this.setState({ fedExAssignments: data })
            })
    }


    getFuelPurchases() {
        fetch('/api/fuelpurchases').then(res => res.json())
            .then(data => {
                console.log(data);
                this.setState({ fuelPurchases: data })
            })
    }

    getEmployees() {
        fetch('/api/employees').then(res => res.json())
            .then(data => {
                console.log(data);
                this.setState({ employees: data })
            })
    }

    getTrucks() {
        fetch('/api/trucks').then(res => res.json())
            .then(data => {
                console.log(data);
                this.setState({ trucks: data })
            })
    }

    getTrips() {
        fetch('/api/trips').then(res => res.json())
            .then(data => {
                console.log(data);
                this.setState({ trips: data })
            })
    }
    toggleNavbar() {
        this.setState({
          collapsed: !this.state.collapsed
        });
      }

    componentWillMount() {
        this.getTrucks()
        this.getTrips()
        this.getEmployees()
        this.getFuelPurchases()
        this.getFedExAssignments()
        this.getCompanies()
    }

    setTrucks = () => {
        this.setState({ currentView: 'trucks' })
    }

    setTrips = () => {
        this.setState({ currentView: 'trips' })
    }

    setEmployees = () => {
        this.setState({ currentView: 'employees' })
    }

    setFuelPurchases = () => {
        this.setState({ currentView: 'fuelPurchases' })
    }

    setFedExAssignments = () => {
        this.setState({ currentView: 'fedExAssignments' })
    }

    setCompanies = () => {
        this.setState({ currentView: 'companies' })
    }

    setCalculations = ( ) => {
        this.setState({ currentView: 'calculations' })
    }

    setDash = ( ) => {
        this.setState({ currentView: 'dash' })
    }

    setStateTrips = (data) => {
        this.setState({ trips: data})
    }

     setUpload = ( ) => {
        this.setState({ currentView: 'upload' })
    }
    handleDrawerToggle = () => {
        this.setState(state => ({ mobileOpen: !state.mobileOpen }));
      };

    render() {
       
        return (
            <div className="App">
               
                <header>
                <Navbar color="faded" light>
                    <NavbarBrand href="/" className="mr-auto">
                        <img className="logo" src={logo}/>
                    </NavbarBrand>
                    <NavbarToggler  onClick={this.toggleNavbar} className="mr-2" />
                    <Collapse  isOpen={!this.state.collapsed} navbar>
                        <Nav navbar>       
                        <NavItem >
                        <ButtonGroup>
                            <Button  className="dash" onClick={this.setDash} outline color="secondary">Dashboard</Button>
                            <Button className="trucks" onClick={this.setTrucks} outline color="primary">Trucks</Button>
                            <Button className="trips" onClick={this.setTrips} outline color="success">Trips</Button>
                            <Button className="employees" onClick={this.setEmployees} outline color="warning">Employees</Button>
                            <Button className="fuelPurchases" onClick={this.setFuelPurchases}  outline color="info">FuelPurchases</Button>
                            <Button className="fedExAssignments" onClick={this.setFedExAssignments} outline color="danger">Assignments</Button>
                            <Button className="companies" onClick={this.setCompanies} outline color="info">Companies</Button>
                            <Button className="calculations" onClick={this.setCalculations} outline color="primary">Calculations</Button>
                            <Button className="upload" onClick={this.setUpload} outline color="danger">Uploader</Button>
                        </ButtonGroup>  
                        </NavItem>   
                        </Nav>
                    </Collapse>
                    </Navbar>
                </header>

                <main>

                    <div>
                      {this.state.currentView === 'dash'
                      ? <Dashboard  trips={this.state.trips}  />
                      :this.state.currentView === 'trucks'
                      ? <Trucks trucks={this.state.trucks} />
                      : this.state.currentView === 'trips'
                      ? <Trips trips={this.state.trips} />
                      : this.state.currentView === 'employees'
                      ? <Employees employees={this.state.employees} />
                      : this.state.currentView === 'fuelPurchases'
                      ? <FuelPurchases fuelPurchases={this.state.fuelPurchases} />
                      : this.state.currentView === 'fedExAssignments'
                      ? <FedExAssignments fedExAssignments={this.state.fedExAssignments} />
                      : this.state.currentView === 'companies'
                      ? <Companies companies={this.state.companies} />
                      : this.state.currentView === 'calculations'
                      ? <Calculations trips={this.state.trips} trucks={this.state.trucks}/>
                      : this.state.currentView === 'upload'
                      ? <Uploader setStateTrips={this.setStateTrips}/>

                      : <h2></h2>}
                    </div>
                    
                </main>
                </div>
            

        );
    }
}

export default App;