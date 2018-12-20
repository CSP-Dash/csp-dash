import React, { Component } from 'react';
import {Bar} from 'react-chartjs-2';
import Chart from 'chart.js'



export default class BarChartComponent extends Component
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
                      backgroundColor:['rgb(216,255,158)',
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
          <Bar
            // height = {240}
            // width = {240}
            data = {this.state.data}
            options = {{ title:{
          display:true,
          text:'Miles By Truck',
          fontSize:25,
          fontColor:'#fff'
        },
        legend:{
          display:false,
          position:'right',
          labels:{
            fontColor:'#fff'
          }
        },
        layout:{
          padding:{
            left:20,
            right:0,
            bottom:0,
            top:0
          }
        },
        tooltips:{
          enabled:true
        },
         scales: {
        xAxes: [ {
          type: 'category',
          display: true,
          scaleLabel: {
            display: true,
            labelString: 'Truck Number',
             fontColor: '#FFF'
          },
          ticks: {
             fontColor: '#FFF',
            major: {
              fontStyle: 'bold',
              fontColor: '#FFF'
            }
          }
        } ],
        yAxes: [ {
          display: true,
          scaleLabel: {
            display: true,
            labelString: 'Miles',
            fontColor:'#fff'
          },
          ticks: {
             fontColor: '#FFF',
            major: {
              fontStyle: 'bold',
              fontColor: '#FFF'
            }
          }
        } ]
      }
         }
       } />
        </div>
      )
   }
}