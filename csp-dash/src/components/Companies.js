import React, { Component } from 'react';

class Companies extends Component {

constructor (props) {
    super(props);
}


    render() {
        return (<div>
                <h3>Companies</h3>

                <table>

                    <tr>
                        <th>Contract Name</th>
                        <th>Contract ID</th>
                        <th>Entity ID</th>
                        <th>Station #</th>
                        <th>Station Name</th>
                        <th>Officer ID</th>
                        <th>Officer Name</th>
                        <th>AUA ID</th>
                        <th>Address</th>
                    </tr>

                    {this.props.companies.map((company, index) =>
                        <tr key={index}>
                            <td>{company.contractName}</td>
                            <td>{company.contractId}</td>
                            <td>{company.entityId}</td>
                            <td>{company.stationNumber}</td>
                            <td>{company.stationName}</td>
                            <td>{company.authOfficerId}</td>
                            <td>{company.authOfficerName}</td>
                            <td>{company.auaId}</td>
                            <td>{company.address}</td>
                        </tr>
                    )}
                </table>
            </div>);
    }
}

export default Companies;