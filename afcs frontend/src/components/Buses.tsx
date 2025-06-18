// components/Buses.tsx
import React, { useEffect, useState } from "react";
import api from "../api/axiosConfig";
import "../App.css";

// Define the Bus type
type Bus = {
  plate: string;
  bus_name: string;
  bus_type: string;
  route: string;
  owner_phone: string;
};

const Buses: React.FC = () => {
  const [buses, setBuses] = useState<Bus[]>([]);

  useEffect(() => {
    const fetchBuses = async () => {
      try {
        const response = await api.get<Bus[]>("/api/v1/bus");
        setBuses(response.data);
      } catch (error) {
        console.error("Error fetching buses:", error);
      }
    };

    fetchBuses();
  }, []);

  return (
    <div>
      <h2 className="table-title">Registered Buses</h2>
      <table className="buses-table">
        <thead>
          <tr>
            <th>S/N</th>
            <th>Plate No</th>
            <th>Bus Name</th>
            <th>Bus Type</th>
            <th>Route</th>
            <th>Owner's Phone</th>
          </tr>
        </thead>
        <tbody>
          {buses.map((bus, index) => (
            <tr key={index}>
              <td>{index + 1}</td>
              <td>{bus.plate}</td>
              <td>{bus.bus_name}</td>
              <td>{bus.bus_type}</td>
              <td>{bus.route}</td>
              <td>{bus.owner_phone}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Buses;
