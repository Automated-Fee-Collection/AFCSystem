import React from "react";
import {  } from "react-router-dom";
import "../App.css";
import adminImage from "../assets/img.png";
import ProfileDropdown from "./ProfileDropdown";


const Topbar: React.FC = () => {
  return (
    <div className="topbar">
      <h4>Automated Fee Collection System</h4>
     <div className="topbar-right">
        <div className="admin-name">
        <h5>{localStorage.getItem("username")}</h5>
        {/* <p>NaneNane Bus Terminal</p> */}
      </div>
        <ProfileDropdown imageUrl={adminImage} />
     </div>
    </div>
  );
};

export default Topbar;