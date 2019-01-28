import React, { Component } from 'react';

class Employees extends Component {

constructor (props) {
	super(props);
}


    render() {
        return (<div>
                <h3>Employees</h3>

                <table  className= "table table-striped bg-white table-bordered table-hoverable table-light">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Miles</th>
                            <th>SSN</th>
                            <th>Fedex Id</th>
                            <th>DOB</th>
                            <th>Phone #</th>
                            <th>Hire Date</th>
                            <th>License #</th>
                            <th>License State</th>
                            <th>License Exp.</th>
                            <th>DOT Physical Exp.</th>
                            <th>Address</th>
                            <th>Email</th>
                        </tr>
                    </thead>
                    <tbody>
                    {this.props.employees.map((employee, index) =>
                        <tr key={index}>

                            <td>{employee.lName}, {employee.fName} {employee.mName}</td>
                            <td>{employee.miles}</td>
                            <td>{employee.ssn}</td>
                            <td>{employee.fedexId}</td>
                            <td>{employee.dateOfBirth}</td>
                            <td>{employee.phoneNumber}</td>
                            <td>{employee.hireDate}</td>
                            <td>{employee.licenseNumber}</td>
                            <td>{employee.licenseState}</td>
                            <td>{employee.licenseExp}</td>
                            <td>{employee.dotPhysicalExp}</td>
                            <td>{employee.address}</td>
                            <td>{employee.email}</td>

                        </tr>
                    )}
                    </tbody>
                </table>
            </div>);
    }
}

export default Employees;