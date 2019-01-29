import React from 'react';
import ReactDOM from 'react-dom';
import './style.css';
import './layout.css';
import App from './App';
import 'bootstrap/dist/css/bootstrap.css';
// import ChangeTheme from './change-theme';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(<App />, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
