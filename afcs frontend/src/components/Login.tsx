import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "../App.css";
import api from "../api/axiosConfig";


const Login: React.FC = () => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState<{
    username: string;
    password: string;
  }>({
    username: "",
    password: "",
  });

  const [errors, setErrors] = useState<{
    username?: string;
    password?: string;
  }>({});
  const [loading] = useState(false);

  const validateForm = (): boolean => {
    const newErrors: { username?: string; password?: string } = {};

    if (!formData.username) {
      newErrors.username = "Username is required.";
    } 

    if (!formData.password) {
      newErrors.password = "Password is required!";
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  // Define the expected response type
interface LoginResponse {
  name: string;
  message: string;
}


  const handleSubmit = async (e: React.FormEvent) => {
  e.preventDefault();
  if (!validateForm()) return;

  try {
    const response = await api.post<LoginResponse>("/api/v1/auth", {
      username: formData.username,
      password: formData.password,
    });

    localStorage.setItem("username", response.data.name);
    const message = response.data.message;

      alert(message);
      navigate("/dashboard/home");

  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  } catch (error: any) {
    if (error.response && error.response.status === 401) {
      console.error("Login error:", error);
      alert("Invalid username or password");
    } else {
      console.error("Login error:", error);
      alert("An error occurred while trying to log in.");
    }

    console.error("Login error:", error);
  }
};



  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  return (
    <div className="login-in-container">
      <h1>Automated Fee Collection System</h1>
      <div className="create-account-container">
      <div className="card create-account-card">
        <h3 className="text-center">Login</h3>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <input
              type="text"
              className="form-control"
              placeholder="Enter Username"
              name="username"
              value={formData.username}
              onChange={handleChange}
            />
            {errors.username && (
              <small className="text-danger">{errors.username}</small>
            )}
          </div>
          <div className="mb-3">
            <input
              type="password"
              className="form-control"
              placeholder="Enter Password"
              name="password"
              value={formData.password}
              onChange={handleChange}
            />
            {errors.password && (
              <small className="text-danger">{errors.password}</small>
            )}
          </div>
          <button
            type="submit"
            className="email-btn btn-primary w-100"
            disabled={loading}
          >
            {loading ? "Logging in..." : "Login"}
          </button>
          <p>
            Forgot Password?{" "}
            <Link to="" className="text-decoration-none">
              Click here
            </Link>
          </p>
        </form>
      </div>
    </div>
    </div>
  );
};

export default Login;
