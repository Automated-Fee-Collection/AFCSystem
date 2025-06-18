// App.tsx
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';

import Home from "./components/Home";
import Login from "./components/Login";
import Buses from "./components/Buses";
import Payments from "./components/Payments";
import Dashboard from "./components/Dashboard";


function App() {
  return (
    <Router>
     <Routes>
  <Route path="/" element={<Login />} />
  <Route path="/dashboard" element={<Dashboard />}>
    <Route path="home" element={<Home />} />
    <Route path="buses" element={<Buses />} />
    <Route path="payments" element={<Payments />} />
  </Route>
</Routes>

    </Router>
  );
}

export default App;

