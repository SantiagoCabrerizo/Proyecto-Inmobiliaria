import React, { useEffect, useState } from "react";
import UserService from "../services/UserService";
import { Link } from 'react-router-dom';

export const HomeEnte = () => {
  const [user, setUser] = useState([]);

  useEffect(() => {
    UserService.getByIdWithToken(localStorage.getItem('sub'), localStorage.getItem('token'))
      .then(res => setUser(res.data))
  }, [])

  return (
    <div>
      <div className="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-body-tertiary">
        <div className="col-md-6 p-lg-5 mx-auto my-5">
          <h1 className="display-4 fw-bold">Bienvenido, {user.nombre}</h1>
          <h3 className="fw-normal text-muted mb-3">Controla aquí todas tus propiedades</h3>
        </div>
      </div>

      <div className="container py-4 mb-4">
        <div className="row align-items-md-stretch">
          <div className="col-md-6">
            <div className="h-100 p-5 text-bg-dark rounded-3">
              <h2>Agregar Propiedad</h2>
              <p>Ingresa una nueva propiedad en tu lista</p>
              <Link to={"/registro_i"} className="fs-2 mb-3 text-white">
                <i className="bi bi-house-add-fill"></i>
              </Link>
            </div>
          </div>
          <div className="col-md-6">
            <div className="h-100 p-5 bg-body-tertiary border rounded-3">
              <h2>Ver Propiedades</h2>
              <p>Mira y controla tu lista de propiedades.</p>
              <Link to={"/propiedades"} className="fs-2 mb-3 text-dark">
                <i className="bi bi-houses-fill"></i>
              </Link>
            </div>
          </div>
        </div>
      </div>

    </div>
  );
};