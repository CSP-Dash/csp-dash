class App extends React.Component {
  
  constructor(props) {
    super(props)
    this.options = {
      type: 'line',
      data: {
        labels: ['1', '2', '3', '4', '5'],
        datasets: [{
          label: "My First dataset",
          backgroundColor: 'rgba(52, 152, 219, 0.75)',
          data: [
            5, 10, 15, 30, 50
          ]
        }, {
          label: "My Second dataset",
          backgroundColor: 'rgba(231, 76, 60, 0.75)',
          data: [
            300, 500, 100, 40, 120
          ]
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
    }
    this.toggleChart = this.toggleChart.bind(this)
  }
  
  toggleChart() {
    this.options.type = this.options.type === 'line' ? 'bar' : 'line'
    this.chart.destroy()
    this.chart = new Chart(this.ctx, this.options)
  }
  
  componentDidMount() {
    this.canvas = document.querySelector('canvas')
    this.ctx = this.canvas.getContext('2d')
    this.chart = new Chart(this.ctx, this.options)
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
export default RevenueChart;