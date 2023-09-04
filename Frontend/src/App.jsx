import "./App.css";
import { BrowserRouter as Router, Routes, Route, Navigate, useNavigate } from "react-router-dom";
import { Header } from "./components/Header";
import { Main } from "./components/Main";
import { Footer } from "./components/Footer";
import { ContactDetails } from "./components/ContactDetails";
import { FormUser } from "./components/FormUser";
import { LogIn } from "./components/LogIn";
import { TestUser } from "./components/TestUser";
import { TestUserDetails } from "./components/TestUserDetails";
import { FormInmueble } from "./components/FormInmueble";

import React, { useEffect, useState } from "react";
import { TestHomeUser } from "./components/TestHomeUser"
import { Logout } from "./components/Logout";

function App() {

  const navigate = useNavigate()

  useEffect(() => {

    const isAuthenticated = localStorage.getItem('token')

    const currentPath = window.location.pathname;

    // Lista de rutas que requieren autenticación
    const protectedRoutes = ['/logueado', '/logout'];


    if (!isAuthenticated && protectedRoutes.includes(currentPath)) {
      navigate("/")
    }
  }, [navigate])

  return (
    <>
      <Header />
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="/contact" element={<ContactDetails />} />
        <Route path="/registro" element={<FormUser />} />

        <Route path="/login" element={<LogIn />}></Route>

        <Route path="/logueado" element={localStorage.getItem('token') ? <TestHomeUser /> : <LogIn />} />

        <Route path="/usuarios" element={<TestUser />} />
        <Route path="/usuarios/:id" element={<TestUserDetails />} />
        <Route path="/registro_i" element={<FormInmueble />} />


        <Route path="/logout" element={<Logout />} />

      </Routes>
      <Footer />
    </>
  );
}

export default App;
