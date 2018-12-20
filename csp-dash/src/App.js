import React, { Component } from 'react';
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


class App extends Component {
    constructor() {
        super()
        this.state = {
            trucks: [],
            trips: [],
            employees: [],
            fuelPurchases: [],
            fedExAssignments: [],
            companies: [],
            currentView: 'dash'

        }
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


    render() {

        return (
            <div className="App">
                
                <header>
                    <nav>

                        <button className="dash" onClick={this.setDash}>Dashboard</button>

                        <button className="trucks" onClick={this.setTrucks}>Trucks</button>
                        <button className="trips" onClick={this.setTrips}>Trips</button>
                        <button className="employees" onClick={this.setEmployees}>Employees</button>
                        <button className="fuelPurchases" onClick={this.setFuelPurchases}>Fuel Purchases</button>
                        <button className="fedExAssignments" onClick={this.setFedExAssignments}>Assignments</button>
                        <button className="companies" onClick={this.setCompanies}>Companies</button>
                        <button className="calculations" onClick={this.setCalculations}>Calculations</button>
                        <button className="upLoad" onClick={this.setUpload}>Upload A File</button>
                    </nav>
                    <figure>
                        <img className="logo" src={logo}/>
                    </figure>
                </header>

                <main>

                    <div>
                      {this.state.currentView === 'dash'
                      ? <Dashboard />
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