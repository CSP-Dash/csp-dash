import React, { Component } from 'react';
import {HorizontalBar} from 'react-chartjs-2';


export default class HorizontalBarChartComponent extends Component
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
                      label:'Trucks',
                       fontColor:'#fff',
                      data:truckRevenue ,
                      backgroundColor:[
                       'rgb(216,255,158)',
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
                    ],
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
          <HorizontalBar
            // height = {240}
            // width = {240}
            data = {this.state.data}
            options = {{ title:{
          display:true,
          text:'Week-Ending Revenue By Truck',
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
          type: 'linear',
          display: true,
          scaleLabel: {
            display: true,
            labelString: 'Week-Ending Revenue',
             fontColor:'#fff'
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
            labelString: 'Truck Numbers',
            fontColor: '#FFF'
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