import "./App.css";
import React, { useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { Header } from "./components/Header";
import { Main } from "./components/Main";
import { Footer } from "./components/Footer";
import { ContactDetails } from "./components/ContactDetails";
import { FormUser } from "./components/FormUser";
import { LogIn } from "./components/LogIn";
import { TestUser } from "./components/TestUser";
import { TestUserDetails } from "./components/TestUserDetails";
import { FormInmueble } from "./components/FormInmueble";
import { useFormState } from "react-hook-form";
import { HomeCliente } from "./components/HomeCliente";
import { HomePropietario } from "./components/HomePropietario";
import { CardsAlquileres } from "./components/CardsAlquileres";

/* 
import { Login2 } from "./components/Login2";
import ProtectedComponent from "./components/ProtectedComponent"; */

function App() {
  /*  const [user, setUser] = useState(null);
  const login = () => {
    setUser({
      id: 1,
      name: "John",
    });
  }; 
  const logout = () => setUser(null);
  */

  return (
    <Router>
      {/*       {user ? (
        <button onClick={login}>Login</button>
      ) : (
        <button onClick={logout}>Logout</button>
      )} */}
      <Header />
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="/contact" element={<ContactDetails />} />
        <Route path="/registro" element={<FormUser />} />
        <Route path="/ingresar" element={<LogIn />} />
        <Route path="/home_cliente" element={<HomeCliente />} />
        <Route path="/cards_alquileres" element={<CardsAlquileres />} />

        <Route path="/usuarios" element={<TestUser />} />
        <Route path="/usuarios/:id" element={<TestUserDetails />} />
        <Route path="/registro_i" element={<FormInmueble />} />
      </Routes>
      <Footer />
    </Router>
  );
}

export default App;
