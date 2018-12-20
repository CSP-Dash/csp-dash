import React, { Component } from 'react';
import {Pie} from 'react-chartjs-2';
import {Bar} from 'react-chartjs-2';
import Chart from 'chart.js'

class MilesChart extends React.Component {
  
  constructor(props) {
    super(props)
    this.state = {
        options: {},
        truckNumber:[],
        truckMileage:[]
      }
   
    this.toggleChart = this.toggleChart.bind(this)
  }
   
  getTrucks() {
        fetch('/api/trucks').then(res => res.json())
            .then(data => {
                console.log(data);
                const trucks = data;
            let truckNumber = [];
            let truckMileage = [];
            trucks.forEach(element => {
              truckNumber.push(element.truckNumber);
              truckMileage.push(element.mileage);
            });
                this.setState({ 
      options: {  
      type: 'bar',
      data: {
        labels: ['1', '2', '3', '4', '5'],
        datasets: [{
          label: "My First dataset",
          backgroundColor: 'rgba(52, 152, 219, 0.75)',
          data:{truckMileage },
        }, {
          label: "My Second dataset",
          backgroundColor: 'rgba(231, 76, 60, 0.75)',
          data: [
            truckMileage
          ],
        }]
      },
      options: {
        title: {
          display: true,
          text: 'Chart.js Toggle with React',
          fontSize: 20
        },
        scales: {
          xAxes: [{
            display: false
          }],
          yAxes: [{
            type: "linear",
            display: true,
            position: "left"
          }]
        },
        responsive: true
      }
    } })
            })
    }

  componentDidMount() {
    this.getTrucks()
    // this.options = {
    //   type: 'bar',
    //   data: {
    //     labels: ['1', '2', '3', '4', '5'],
    //     datasets: [{
    //       label: "My First dataset",
    //       backgroundColor: 'rgba(52, 152, 219, 0.75)',
    //       data:{ },
    //     }, {
    //       label: "My Second dataset",
    //       backgroundColor: 'rgba(231, 76, 60, 0.75)',
    //       data: [
    //         300, 500, 100, 40, 120
    //       ]
    //     }]
    //   },
    //   options: {
    //     title: {
    //       display: true,
    //       text: 'Chart.js Toggle with React',
    //       fontSize: 20
    //     },
    //     scales: {
    //       xAxes: [{
    //         display: false
    //       }],
    //       yAxes: [{
    //         type: "linear",
    //         display: true,
    //         position: "left"
    //       }]
    //     },
    //     responsive: true
    //   }
    // }
    this.canvas = document.querySelector('canvas')
    this.ctx = this.canvas.getContext('2d')
    this.chart = new Chart(this.ctx, this.state.options)
       }   
        
         toggleChart() {
    this.setState.options.type = this.setState.options.type === 'bar' ? 'pie' : 'bar'
    this.chart.destroy()
    this.chart = new Chart(this.ctx, this.setState.options)
  }

  
  render() {
    return (
      <div>
        <canvas />
        <div className="text-center">
          <button className="btn btn-primary" onClick={this.toggleChart}>Toggle</button>
        </div>
      </div>
    )
  }
}
export default MilesChart;