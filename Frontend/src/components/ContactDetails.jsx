/* 
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
    <div>
      <h1>ID: {inmueble[0][0].id}</h1>
      <p>Dirección: {inmueble[0][0].direccion}</p>
      <p>Características: {inmueble[0][0].caracteristicas}</p>
      <p>Tipo de Inmueble: {inmueble[0][0].tiposInmueble}</p>

      <img
        src={`data:image/png;base64,${inmueble[0][1]}`}
        alt="Imagen del inmueble"
      />
    </div>
  );
};
 */

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
    <div className="card">
      <img
        src={`data:image/png;base64,${inmueble[0][1]}`}
        className="card-img-top w-50" // Clase para hacer que la imagen ocupe el 50% del ancho de la tarjeta
        alt="Imagen del inmueble"
      />
      <div className="card-body">
        <h5 className="card-title">ID: {inmueble[0][0].id}</h5>
        <p className="card-text">Dirección: {inmueble[0][0].direccion}</p>
        <p className="card-text">
          Características: {inmueble[0][0].caracteristicas}
        </p>
        <p className="card-text">
          Tipo de Inmueble: {inmueble[0][0].tiposInmueble}
        </p>
      </div>
    </div>
  );
};
