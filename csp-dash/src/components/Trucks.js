import React, { Component } from 'react';

class Trucks extends Component {

constructor (props) {
	super(props);
}


    render() {
        return (<div>
                <h3>Trucks</h3>
                <table className= "table table-striped bg-white table-bordered table-hoverable table-light">
                    <tr>
                        <th>Truck #</th>
                        <th>Make</th>
                        <th>Model</th>
                        <th>Year</th>
                        <th>VIN</th>
                        <th>Plate #</th>
                        <th>Actual Run</th>
                        <th>Miles Between Service</th>
                        <th>Inspection Date</th>
                        <th>Miles Until Service</th>
                    </tr>
                    {this.props.trucks.map((truck, index) =>
                        <tr key={index}>
                            <td>{truck.truckNumber}</td>
                            <td>{truck.make}</td>
                            <td>{truck.model}</td>
                            <td>{truck.year}</td>
                            <td>{truck.vIn}</td>
                            <td>{truck.plateNumber}</td>
                            <td>{truck.actualRun}</td>
                            <td>{truck.milesBetweenService}</td>
                            <td>{truck.dotInspectionDate}</td>
                            <td>{truck.milesTillService}</td>
                        </tr>
                    )}
                </table>
            </div>);
    }
}

export default Trucks;