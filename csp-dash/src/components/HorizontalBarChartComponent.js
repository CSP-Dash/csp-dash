import React, { Component } from 'react';
import {HorizontalBar} from 'react-chartjs-2';


export default class HorizontalBarChartComponent extends Component
{
   constructor(props) {
      super(props);
      this.state = {
        data: {},
        truckNumber:[],
        truckMileage:[]
      }
    }
       
      componentDidMount() {
        fetch('http://localhost:8080/api/trucks')
          .then(res => res.json())
          .then(data => {
            const trucks = data;
            let truckNumber = [];
            let truckMileage = [];
            trucks.forEach(element => {
              truckNumber.push(element.truckNumber);
              truckMileage.push(element.mileage);
            });
            this.setState({ 
              data: {
                labels: truckNumber,
                datasets:[
                   {
                      label:'Trucks',
                      data: truckMileage ,
                      backgroundColor:[
                       'rgba(255,105,145,0.6)',
                       'rgba(155,100,210,0.6)',
                       'rgba(90,178,255,0.6)',
                       'rgba(240,134,67,0.6)',
                       'rgba(120,120,120,0.6)',
                       'rgba(255,105,145,0.6)',
                       'rgba(155,100,210,0.6)',
                       'rgba(90,178,255,0.6)',
                       'rgba(240,134,67,0.6)',
                       'rgba(120,120,120,0.6)',
                       'rgba(255,105,145,0.6)',
                       'rgba(155,100,210,0.6)',
                       'rgba(90,178,255,0.6)',
                       'rgba(240,134,67,0.6)',
                       'rgba(120,120,120,0.6)',
                       'rgba(250,55,197,0.6)'
                    ]
                   }
                ]
             }
             });
          })
      }
 render()
   {
      return(
        <div className="chart">
        <h1>Horizontal BarChart</h1>
          <HorizontalBar
            // height = {240}
            // width = {240}
            data = {this.state.data}
            options = {{ maintainAspectRatio: true }} />
        </div>
      )
   }
}