import React, { Component } from 'react';

class FuelPurchases extends Component {

constructor (props) {
	super(props);
}


    render() {
        return (<div>
                <h3>Fuel Purchases</h3>

                <table  className= "table table-striped bg-white table-bordered table-hoverable table-light">
                    <tr>
                        <th>Purchase Date</th>
                        <th>Ticket Check #</th>
                        <th>Truck #</th>
                        <th>Truck Stop</th>
                        <th>City</th>
                        <th>State</th>
                        <th>Gallons QTY</th>
                        <th>Gallons Cost</th>
                        <th>Auth Chgbk Arrears</th>
                        <th>Auth Chgbk Refund</th>
                        <th>Auth Chgbk Net AMT</th>
                        <th>Repair Misc. AMT</th>
                    </tr>

                    {this.props.fuelPurchases.map((fuelPurchase, index) =>
                        <tr key={index}>

                            <td>{fuelPurchase.date}</td>
                            <td>{fuelPurchase.ticketCheckNumber}</td>
                            <td>{fuelPurchase.truckNumber}</td>
                            <td>{fuelPurchase.truckStop}</td>
                            <td>{fuelPurchase.city}</td>
                            <td>{fuelPurchase.state}</td>
                            <td>{fuelPurchase.gallonsQty}</td>
                            <td>{fuelPurchase.gallonsCost}</td>
                            <td>{fuelPurchase.authChgbkArrears}</td>
                            <td>{fuelPurchase.authChgbkRefund}</td>
                            <td>{fuelPurchase.authChgbkNetAmt}</td>
                            <td>{fuelPurchase.repairMiscAmount}</td>
                        </tr>
                    )}
                </table>
            </div>);
    }
}

export default FuelPurchases;