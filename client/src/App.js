import React from "react";

import {
  BrowserRouter as Router,
  Route,
  Routes,
} from "react-router-dom";
import "./App.css";

import history from "./history"
import Login from "./components/Login";
import Statistical from "./components/Statistical";
const App = () => {
  return (
    <Router history={history}>
      <div className="w-100">
          <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/statistical" element={<Statistical />} />
          </Routes>
      </div>
    </Router>
  );
};

export default App;