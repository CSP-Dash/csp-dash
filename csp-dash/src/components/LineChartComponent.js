import React, { Component } from 'react';
import {Line} from 'react-chartjs-2';
import {Pie} from 'react-chartjs-2';
import {Bar} from 'react-chartjs-2';
import Chart from 'chart.js'


export default class LineChartComponent extends Component
{
   constructor(props) {
      super(props);
      this.state = {
        data: {},
         truck: 'all',
        month: 'all',
        year: 'all',
        truckNumber:[],
        truckMileage:[],
        truckRevenue:[]
      }
    }
     countTruckRevenue = () => {
        let revenue = 0
        const truckId = this.state.truck
        const month = this.state.month
        const year = this.state.year

        this.props.trips.map(function(trip, index){
            if(trip.truck.truckNumber==truckId){
                
                revenue += trip.dailyGrossAmount
            }
        })
        revenue=Math.floor(revenue*100)/100;
        return(revenue)
    }

       
      componentDidMount() {
        const that = this
        fetch('http://localhost:8080/api/trucks')
          .then(res => res.json())
          .then(data => {
            const trucks = data;
            let truckNumber = [];
            let truckMileage = [];
            let truckRevenue = [];
            trucks.forEach(element => {
              truckNumber.push(element.truckNumber);
              truckMileage.push(element.mileage);
              that.setState({
                truck:element.truckNumber
              })
              console.log(that.countTruckRevenue());
              truckRevenue.push(that.countTruckRevenue())
            });
            that.setState({
             
              data: {
                labels: truckNumber,
                fontColor:'#fff',
                datasets:[
                   {  

                      label:'Revenue',
                      data:truckRevenue ,
                      fill: true,
                      fontColor:'#fff',
                      borderDash: [5, 5],
                      backgroundColor:
                       'rgb(216,255,158)',
                       }
                   ,
                    {
                     
                      label:'Miles',
                      data:truckMileage ,
                      fontColor:'#fff',
                      fill: true,
                      borderDash: [5, 5],
                      backgroundColor:
                       'rgba(250,55,197,0.6)',
                       
                    
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
          <Line
            // height = {240}
            // width = {240}
            data = {this.state.data}
            options = {{ title:{
              scaleFontColor:'#fff',
          display:true,
          text:'Track Revenue And Miles',
          fontSize:25,
          fontColor:'#fff'
        },
        legend:{
          display:true,
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
            labelString: 'Truck Numbers',
            fontColor:'#fff'
          },
          ticks: {
            fontColor:'#fff',
            major: {
              fontStyle: 'bold',
              fontColor: '#FF0000'
            }
          }
        } ],
        yAxes: [ {
          display: true,
          scaleLabel: {
            display: true,
            labelString: 'Revenue and Miles',
            fontColor:'#fff'
          },
          ticks: {
            beginAtZero:true,
            fontColor:'#fff',
            major: {
              fontStyle: 'bold',
              fontColor: '#FF0000'
            }
        }
      }]
         
       }
     } 
   }
   />
        </div>
      )
   }
}