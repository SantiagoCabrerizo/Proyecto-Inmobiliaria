/* import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import InmuebleService from "../services/InmuebleService";
import { base64StringToBlob } from "blob-util";
import { TestInmuebleById } from "./TestInmuebleById";

export const TestInmuebleById = () => {


  const [inmuebleData, setInmuebleData] = useState(null);

  useEffect(() => {
    const loadInmuebleData = async () => {
      try {
        const inmuebleId = localStorage.getItem("selectedInmuebleId"); // Obtén el ID del inmueble de alguna manera.
        const response = await InmuebleService.getInmuebleById(inmuebleId);
        setInmuebleData(response.data);
        debugger;
      } catch (error) {
        console.error("Error al obtener el inmueble", error);
      }
    };

    loadInmuebleData();
  }, []);

  if (!inmuebleData) {
    return <div>Cargando...</div>;
  }

  return (
    <div>
      <p className="small text-muted mb-1">Dirección : {row[0].direccion}</p>
      <p className="small text-muted mb-1">
        Características : {inmuebleData.caracteristicas}
      </p>
    </div>
  );
};
*/
