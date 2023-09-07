import React, { useState, useEffect } from "react";
import InmuebleService from "../services/InmuebleService";
import { base64StringToBlob } from "blob-util";

export const ContactDetails = () => {
  const [inmueble, setInmueble] = useState(null);

  const inmuebleId = localStorage.getItem("selectedInmuebleId"); // El ID del inmueble que deseas obtener

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await InmuebleService.getInmuebleById(inmuebleId);
        setInmueble(response.data);
      } catch (error) {
        console.error("Error al obtener el inmueble", error);
      }
    };

    fetchData();
  }, []);

  if (!inmueble) {
    return <div>Cargando...</div>;
  }

  return (
    <div className="card mb-3" style={{ maxWidth: "600px" }}>
      <div className="row g-0">
        <div className="col-md-4">
          <img
            src={`data:image/png;base64,${inmueble[0][1]}`}
            className="img-fluid rounded-start"
            alt="Imagen del inmueble"
          />
        </div>
        <div className="col-md-8">
          <div className="card-body">
            <h5 className="card-title">Detalles del Inmueble</h5>
            <p className="card-text">Dirección: {inmueble[0][0].direccion}</p>
            <p className="card-text">
              Características: {inmueble[0][0].caracteristicas}
            </p>
            <p className="card-text">
              Tipo de Inmueble: {inmueble[0][0].tiposInmueble}
            </p>
            <p className="card-text">Valor : {inmueble[0][0].valor}</p>
          </div>
        </div>
      </div>
    </div>
  );
};
