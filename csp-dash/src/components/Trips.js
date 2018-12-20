import React, { Component } from 'react';

class Trips extends Component {

constructor (props) {
    super(props);
    
}


    render() {
        return (<div>
                <h3>Trips</h3>

                <table>
                    <tr>
                        <th>Truck #</th>
                        <th>Trip #</th>
                        <th>Date</th>
                        <th>Orig.</th>
                        <th>Dest.</th>
                        <th>Zip</th>
                        <th>Miles QTY</th>
                        <th>VMR</th>
                        <th>Mileage</th>
                        <th>Premiums</th>
                        <th>Fuel</th>
                        <th>Total Rate</th>
                        <th>AMT</th>
                        <th>Packages</th>
                        <th>Package AMT</th>
                        <th>D & H</th>
                        <th>Tolls</th>
                        <th>Flat Rate</th>
                        <th>Daily Gross AMT</th>
                        <th>Driver One</th>
                        <th>Driver Two</th>
                        <th>Week Ending</th>
                    </tr>

                {this.props.trips.map((trip, index) =>
                    <tr key={index}>
                        <td>{trip.truck.truckNumber}</td>
                        <td>{trip.tripNumber}</td>
                        <td>{trip.date}</td>
                        <td>{trip.origin}</td>
                        <td>{trip.destination}</td>
                        <td>{trip.zipCode}</td>
                        <td>{trip.milesQuantity}</td>
                        <td>${trip.vMr}</td>
                        <td>${trip.mileagePlus}</td>
                        <td>${trip.premiums}</td>
                        <td>${trip.fuel}</td>
                        <td>${trip.totalRate}</td>
                        <td>${trip.aMt}</td>
                        <td>{trip.packages}</td>
                        <td>${trip.packageAmt}</td>
                        <td>${trip.dropAndHook}</td>
                        <td>${trip.tolls}</td>
                        <td>${trip.flatRate}</td>
                        <td>${trip.dailyGrossAmount}</td>
                        <td>{trip.driverOne}</td>
                        <td>{trip.driverTwo}</td>
                        <td>{trip.weekEnding}</td>
                    </tr>

                )}
                </table>
            </div>);
    }
}

export default Trips;