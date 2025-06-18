import React, { useEffect, useState } from "react";
import api from "../api/axiosConfig";
import "../App.css";
import PaginationControls from "./PaginationControls";

// Define the Bus type
type Arrivals = {
  plate: string;
  bus_name: string;
  arrival_time: string;
  fee: number;
};

const Home: React.FC = () => {
  const [arrivals, setArrivals] = useState<Arrivals[]>([]);

// Pagination
const itemsPerPage = 10;
const [currentPage, setCurrentPage] = useState(1);
const startIndex = (currentPage - 1) * itemsPerPage;
const endIndex = startIndex + itemsPerPage;
const paginatedArrivals = arrivals.slice(startIndex, endIndex);


const handleNext = () => {
  if (currentPage < Math.ceil(arrivals.length / itemsPerPage)) {
    setCurrentPage(prev => prev + 1);
  }
};

const handlePrev = () => {
  if (currentPage > 1) {
    setCurrentPage(prev => prev - 1);
  }
};


  useEffect(() => {
    const fetchArrivals = async () => {
      try {
        const response = await api.get<Arrivals[]>("/api/v1/arrivals");
        setArrivals(response.data);
      } catch (error) {
        console.error("Error fetching arrivals:", error);
      }
    };

    fetchArrivals();
  }, []);
  return (
  <div>
    <h2>Welcome to the Automated Fee Collection Dashboard</h2>
      <h2 className="table-title">Recent Arrived Buses</h2>
      {paginatedArrivals.length === 0 ? (
  <p className="no-items-message">Check your internet then reload the page</p>
) : (
  <table className="buses-table">
    <thead>
      <tr>
        <th>S/N</th>
        <th>Plate No</th>
        <th>Bus Name</th>
        <th>Arrival Time</th>
        <th>Fee (TZS)</th>
      </tr>
    </thead>
    <tbody>
      {paginatedArrivals.map((arrival, index) => (
        <tr key={index}>
          <td>{startIndex + index + 1}</td>
          <td>{arrival.plate}</td>
          <td>{arrival.bus_name}</td>
          <td>{arrival.arrival_time}</td>
          <td>{arrival.fee}</td>
        </tr>
      ))}
    </tbody>
  </table>
)}
      <div className="pagination-container">
        <PaginationControls
          currentPage={currentPage}
          totalPages={Math.ceil(arrivals.length / itemsPerPage)}
          onNext={handleNext}
          onPrev={handlePrev}
        />
      </div>
    </div>
);
};

export default Home;
