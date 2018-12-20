import React, { Component } from 'react';
import BarChartComponent from './BarChartComponent';
import HorizontalBarChartComponent from './HorizontalBarChartComponent';
import PieChartComponent from './PieChartComponent';
import LineChartComponent from './LineChartComponent';

class Dashboard extends Component {

constructor (props) {
	super(props)
}


    render() {
        return (<div className="chartDash">
                <section className="wrapper">
                          <figure className="box a">
                            <BarChartComponent />
                          </figure>
                          <figure className="box b">  
                          
                            <PieChartComponent />
                          </figure>
                           <figure className="box c"> 
                          
                            <LineChartComponent />
                          </figure>  
                          <figure className="box d">  
                           
                            <HorizontalBarChartComponent />
                          </figure> 
                      </section> 
            </div>);
    }
}

export default Dashboard;