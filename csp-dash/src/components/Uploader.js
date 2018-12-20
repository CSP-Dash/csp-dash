import React, { Component } from 'react';
import Papa from 'papaparse'
class Uploader extends Component {

   constructor(props) {
    super(props);
    this.state = {value: ''};

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  setDataValue = ( results ) => {
    this.setState({value: results})
  }

  handleChange(event) {
    const that = this
    Papa.parse(event.target.files[0], {
      header: true,
      complete: function(results) {
        that.setDataValue(results.data)
        console.log("Finished:", results.data)
      }
    })
  }

  handleSubmit(event) {
    const that = this
    return this.state.value.map(function(trip, index){
        fetch('/api/add/trips', {
          method: 'POST',
          mode: 'no-cors',
          body: JSON.stringify(trip),
        }).then((response) => {
          console.log(trip)
          console.log(response)
          return response.json()
        }).then(data => that.props.setStateTrips(data));
        // event.preventDefault();
    })
  }
   
  render() {
    return (
      <section className="uploader">
        
          <input type="file" onChange={this.handleChange}  />
        
        <button onClick={this.handleSubmit}>Submit</button>
      </section>
    )
  }
}

export default Uploader;
