import React, { Component } from 'react';

class FedExAssignments extends Component {

constructor (props) {
    super(props);
}


    render() {
        return (<div>
                <h3>Assignments</h3>

                <table  className= "table table-striped bg-white table-bordered table-hoverable table-light">

                    <tr>
                        <th>Contract Name</th>
                        <th>Truck #</th>
                        <th>Service %</th>
                        <th>Availability %</th>
                        <th>Points</th>
                    </tr>

                    {this.props.fedExAssignments.map((fedExAssignment, index) =>
                        <tr key={index}>
                            <td>{fedExAssignment.company.contractName}</td>
                            <td>{fedExAssignment.truck.truckNumber}</td>
                            <td>{fedExAssignment.servicePercentage}</td>
                            <td>{fedExAssignment.availabilityPercentage}</td>
                            <td>{fedExAssignment.points}</td>

                        </tr>
                    )}

                </table>
            </div>);
    }
}

export default FedExAssignments;