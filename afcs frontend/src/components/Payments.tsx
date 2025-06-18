import React, { useEffect, useState } from "react";
import api from "../api/axiosConfig";
import "../App.css";

// Define the Bus type
type Payments = {
  plate: string;
  bus_name: string;
  arrival_time: string;
  fee: number;
  payment_status: string;
};

const Payments: React.FC = () => {
  const [payments, setPayments] = useState<Payments[]>([]);

  useEffect(() => {
    const fetchPayments = async () => {
      try {
        const response = await api.get<Payments[]>("/api/v1/payments");
        setPayments(response.data);
      } catch (error) {
        console.error("Error fetching buses:", error);
      }
    };

    fetchPayments();
  }, []);
  return (
  <div>
      <h2 className="table-title">Fee payment status</h2>
      <table className="buses-table">
        <thead>
          <tr>
            <th>S/N</th>
            <th>Plate No</th>
            <th>Bus Name</th>
            <th>Arrival Time</th>
            <th>Fee (TZS)</th>
            <th>Payment Status</th>
          </tr>
        </thead>
        <tbody>
          {payments.map((payment, index) => (
            <tr key={index}>
              <td>{index + 1}</td>
              <td>{payment.plate}</td>
              <td>{payment.bus_name}</td>
              <td>{payment.arrival_time}</td>
              <td>{payment.fee}</td>
              <td>{payment.payment_status}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
);
};

export default Payments;