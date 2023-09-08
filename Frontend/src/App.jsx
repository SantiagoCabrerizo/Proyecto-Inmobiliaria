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

import React, { useEffect } from "react";
import { Logout } from "./components/Logout";
import { HomeClient } from "./components/HomeClient";
import { HomeEnte } from './components/HomeEnte';
import { Perfil } from "./components/Perfil";
import { Propiedades } from "./components/Propiedades";
import { HeaderLogueado } from "./components/HeaderLogueado";
import { ListPropiedades } from "./components/ListPropiedades";

function App() {

  const navigate = useNavigate()
  const rol = localStorage.getItem('roles')

  useEffect(() => {
    const isAuthenticated = localStorage.getItem('token')
    const currentPath = window.location.pathname;
    const protectedRoutes = ['/home', '/logout'];
    if (!isAuthenticated && protectedRoutes.includes(currentPath)) {
      navigate("/")
    }
  }, [navigate])

  return (
    <>
      {localStorage.getItem('token') ? (
        <HeaderLogueado/>
      ): (
        <Header/>
      )}
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="/contact" element={<ContactDetails />} />
        <Route path="/registro" element={localStorage.getItem('token') ? <Logout /> : <FormUser />} />

        <Route path="/login" element={<LogIn />}></Route>

        <Route path="/home" element={localStorage.getItem('token') ?
          (rol == 'ROLE_CLIENT' ? <HomeClient /> : rol == 'ROLE_ENTE' ? <HomeEnte /> : (<LogIn />)) : <LogIn />}
        />

        <Route path="/usuarios" element={<TestUser />} />
        <Route path="/usuarios/:id" element={<TestUserDetails />} />
        <Route path="/registro_i" element={<FormInmueble />} />

        <Route path="/perfil" element={localStorage.getItem('token') ? <Perfil /> : <LogIn />} />
        <Route path="/propiedades" element={localStorage.getItem('token') ? <Propiedades /> : <LogIn />} />
        <Route path="/listado" element={<ListPropiedades/>} />
        <Route path="/logout" element={<Logout />} />

      </Routes>
      <Footer />
    </>
  );
}

export default App;
