// components/Dashboard.tsx
import React from "react";
import { Outlet } from "react-router-dom";
import Topbar from "./Topbar";
import Sidebar from "./Sidebar";
import "../App.css";

const Dashboard: React.FC = () => {
  return (
    <div className="dashboard-container">
      <Sidebar />
      <Topbar />
      <div className="main-content">
        <Outlet />
      </div>
    </div>
  );
};

export default Dashboard;
