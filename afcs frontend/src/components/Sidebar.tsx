// components/Sidebar.tsx
import React from "react";
import { NavLink } from "react-router-dom";
import "../App.css";

const Sidebar: React.FC = () => {
  return (
    <div className="sidebar">
      <NavLink to="home" className="sidebar-link">Home</NavLink>
      <NavLink to="buses" className="sidebar-link">Buses</NavLink>
      <NavLink to="payments" className="sidebar-link">Payments</NavLink>
      {/* <NavLink to="/" className="sidebar-link">Logout</NavLink> */}
    </div>
  );
};

export default Sidebar;
