import React, { Component } from "react";
import { SportsStoreDataStore } from "./data/DataStore"; import { Provider } from "react-redux";
import { BrowserRouter as Router, Route, Switch, Redirect }
from "react-router-dom";
import { ShopConnector } from "./shop/ShopConnector";

export default class App extends Component {

    render() {
        return <Provider store={ SportsStoreDataStore }>
                <Router>
                    <Switch>
                        <Route path="/shop" component={ ShopConnector } />
                        <Redirect to="/shop" /> </Switch>
                </Router>
            </Provider>
    }
}


/**export default class App extends Component {
    render() {
        return (
            <div>
                <h4 className="bg-primary text-white text-center p-2">To Do List</h4>
            </div>
        )
    };
}*/
