import React, { useState, useEffect } from "react";
import axios from "axios";

export const CardsAlquileres = () => {
  const [alquileres, setAlquileres] = useState([]);

  useEffect(() => {
    // Realiza una solicitud al backend para obtener los datos de alquiler
    const obtenerAlquileres = async () => {
      try {
        const response = await axios.get("/api/mis-alquileres", {
          headers: {
            Authorization: `Bearer ${localStorage.getItem("authToken")}`,
          },
        });
        setAlquileres(response.data);
      } catch (error) {
        console.error("Error al obtener alquileres", error);
      }
    };

    obtenerAlquileres();
  }, []);

  return (
    <div className="container mt-4">
      <h2>Mis Alquileres</h2>
      <div className="row">
        {alquileres.map((alquiler) => (
          <div className="col-md-4 mb-4" key={alquiler.id}>
            <div className="card">
              <div className="card-body">
                <h5 className="card-title">{alquiler.titulo}</h5>
                <p className="card-text">{alquiler.descripcion}</p>
                <p className="card-text">Precio: ${alquiler.precio}</p>
                {/* Otros detalles del alquiler */}
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
