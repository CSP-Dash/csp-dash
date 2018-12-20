import React, { Component } from 'react';

class Calculations extends Component {

constructor (props) {
    super(props);
    this.state = {
        truck: 'all',
        month: 'all',
        year: 'all'
    }
}

    countTotalMiles = () => {
        let miles = 0
        this.props.trips.map(function(trip, index){
            miles += trip.milesQuantity
        })
        return(miles)
    }

    countTotalAMT = () => {
        let AMT = 0
        this.props.trips.map(function(trip, index){
            AMT += trip.aMt
        })
        AMT=Math.floor(AMT*100)/100;
        return(AMT)
    }

    countTotalPackages = () => {
        let packages = 0
        this.props.trips.map(function(trip, index){
            packages += trip.packages
        })
        return(packages)
    }

    countTotalPackageAmt = () => {
        let packageAmt = 0
        this.props.trips.map(function(trip, index){
            packageAmt += trip.packageAmt
        })
        return(packageAmt)
    }

    countTotalDropAndHook = () => {
        let dropAndHook = 0
        this.props.trips.map(function(trip, index){
            dropAndHook += trip.dropAndHook
        })
        return(dropAndHook)
    }

    countTotalTolls = () => {
        let tolls = 0
        this.props.trips.map(function(trip, index){
            tolls += trip.tolls
        })
        return(tolls)
    }

    countTotalFlatRate = () => {
        let flatRate = 0
        this.props.trips.map(function(trip, index){
            flatRate += trip.flatRate
        })
        return(flatRate)
    }

    countTotalDailyGrossAmount = () => {
        let dailyGross = 0
        this.props.trips.map(function(trip, index){
            dailyGross += trip.dailyGrossAmount
        })
        dailyGross=Math.floor(dailyGross*100)/100;
        return(dailyGross)
    }

    countUniqueTrucks = () => {
        let truckList = []
        this.props.trips.map(function(trip, index){
            if(!truckList.includes(trip.truck.id)){
                truckList.push(trip.truck.id)
            }
        })
        return(truckList.length)
    }

    countTruckMiles = () => {
        let miles = 0
        const truckId = this.state.truck
        const month = this.state.month
        const year = this.state.year

        this.props.trips.map(function(trip, index){
            if((trip.truck.id==truckId||truckId=='all')&&(trip.weekEnding.split("-")[1]==month||month=='all')&&(trip.weekEnding.split("-")[0]==year||year=='all')){
                miles += trip.milesQuantity
            }
        })
        return(miles)
    }


    countTruckRevenue = () => {
        let revenue = 0
        const truckId = this.state.truck
        const month = this.state.month
        const year = this.state.year

        this.props.trips.map(function(trip, index){
            if((trip.truck.id==truckId||truckId=='all')&&(trip.weekEnding.split("-")[1]==month||month=='all')&&(trip.weekEnding.split("-")[0]==year||year=='all')){
                
                revenue += trip.dailyGrossAmount
            }
        })
        revenue=Math.floor(revenue*100)/100;
        return(revenue)
    }


    handleTruckChange = (event) => {
        this.setState({ truck: event.target.value });
    }

    handleMonthChange = (event) => {
        this.setState({ month: event.target.value });
    }

    handleYearChange = (event) => {
        this.setState({ year: event.target.value });
    }

    render() {

        const { value } = this.state;

        return (
            <div>
                <h3>Calculations</h3>
                <section>
                    <h2>All Trips</h2>
                    <p>Total Miles: {this.countTotalMiles()}</p>
                    <p>Total AMT: ${this.countTotalAMT()}</p>
                    <p>Total Packages: {this.countTotalPackages()}</p>
                    <p>Total PackageAMT: ${this.countTotalPackageAmt()}</p>
                    <p>Total Drop and Hook: ${this.countTotalDropAndHook()}</p>
                    <p>Total Tolls: ${this.countTotalTolls()}</p>
                    <p>Total Flat Rate: ${this.countTotalFlatRate()}</p>
                    <p>Total Daily Gross Amount: ${this.countTotalDailyGrossAmount()}</p>
                    <p>Trucks: {this.countUniqueTrucks()}</p>
                    <p>Average miles per truck: {this.countTotalMiles() / this.countUniqueTrucks()}</p>
                </section>
                <section>
                    <h2>Mileage Calculations</h2>
                    <label>Select Truck: <select onChange={this.handleTruckChange} value={value} >
                        <option value='all'>All</option>    
                        {this.props.trucks.map((truck) => {
                            return <option key={truck.id} value={truck.id}>{truck.truckNumber}</option>
                        })}
                    </select></label>
                    <label>Select Month: <select onChange={this.handleMonthChange} value={value} >
                        <option value='all'>All</option>
                        <option value='01'>January</option>
                        <option value='02'>February</option>
                        <option value='03'>March</option>
                        <option value='04'>April</option>
                        <option value='05'>May</option>
                        <option value='06'>June</option>
                        <option value='07'>July</option>
                        <option value='08'>August</option>
                        <option value='09'>September</option>
                        <option value='10'>October</option>
                        <option value='11'>November</option>
                        <option value='12'>December</option>
                    </select></label>

                    <label>Select Year: <select onChange={this.handleYearChange} value={value} >
                        <option value='all'>All</option>
                        <option value='2017'>2017</option>
                        <option value='2018'>2018</option>
                        
                    </select></label>
                    <p>Truck miles: {this.countTruckMiles()}</p>
                </section>
                <section>
                    <h2>Revenue Calculations</h2>
                    <label>Select Truck: <select onChange={this.handleTruckChange} value={value} >
                        <option value='all'>All</option>    
                        {this.props.trucks.map((truck) => {
                            return <option key={truck.id} value={truck.id}>{truck.truckNumber}</option>
                        })}
                    </select></label>
                    <label>Select Month: <select onChange={this.handleMonthChange} value={value} >
                        <option value='all'>All</option>
                        <option value='01'>January</option>
                        <option value='02'>February</option>
                        <option value='03'>March</option>
                        <option value='04'>April</option>
                        <option value='05'>May</option>
                        <option value='06'>June</option>
                        <option value='07'>July</option>
                        <option value='08'>August</option>
                        <option value='09'>September</option>
                        <option value='10'>October</option>
                        <option value='11'>November</option>
                        <option value='12'>December</option>
                    </select></label>

                    <label>Select Year: <select onChange={this.handleYearChange} value={value} >
                        <option value='all'>All</option>
                        <option value='2017'>2017</option>
                        <option value='2018'>2018</option>
                        
                    </select></label>
                    <p>Revenue: ${this.countTruckRevenue()}</p>
                </section>
            </div>
        );
    }
}

export default Calculations;