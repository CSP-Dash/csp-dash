import React, { Component } from 'react';
import BarChartComponent from './BarChartComponent';
import HorizontalBarChartComponent from './HorizontalBarChartComponent';
import PolarChartComponent from './PolarChartComponent';
import LineChartComponent from './LineChartComponent';
import MilesChart from './MilesChart';

class Dashboard extends Component {

constructor (props) {
	super(props)
   this.state = {
        truck: 'all',
        month: 'all'
       
    }
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


    render() {
        return (<div className="chartDash">
                <section className="wrapper">
                          <figure className="box a">
                            <BarChartComponent />
                            
                          </figure>
                          <figure className="box b">  
                          
                            <LineChartComponent trips={this.props.trips} />
                          </figure>
                           <figure className="box c"> 
                          
                            <PolarChartComponent />
                          </figure>  
                          <figure className="box d">  
                           
                            <HorizontalBarChartComponent  trips={this.props.trips} />
                          </figure> 
                      </section> 
            </div>);
    }
}

export default Dashboard;