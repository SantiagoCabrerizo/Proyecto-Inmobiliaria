/* import React from "react";
import { Project } from "./Project";

export const Projects = () => {
  return (
    <>
      <section
        id="venta"
        className="proyectos-recientes seccion-clara d-flex flex-column"
      >
        <h2 className="seccion-titulo texto-negro">Ventas destacadas</h2>
        <h3 className="seccion-descripcion">
          <i className="bi bi-geo-alt-fill me-1"></i>
          Estas son algunas de las propiedades dentro de tu zona...
        </h3>

       
            <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
         
              
      
              <Project />
              
            
            
          </div>
          
        

        <a href="https://github.com/" target="_blank" rel="noopener noreferrer">
          <button type="button" className="btn btn-dark">
            Ver más
            <i className="bi bi-arrow-right-circle ms-2"></i>
          </button>
        </a>
      </section>
    </>
  );
};
 */
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import InmuebleService from "../services/InmuebleService";
import { base64StringToBlob } from 'blob-util';

export const Projects = () => {
  const [inmueble, setInmueble] = useState({ content: [] });
  const [imageUrl, setImageUrl] = useState(""); // Estado para almacenar la URL de la imagen

  useEffect(() => {
      InmuebleService.getInmuebleAll()
          .then((res) => {
              setInmueble(res.data);
          })
          .catch((error) => {
              console.error("Error al obtener datos o crear la URL de la imagen:", error);
          });
  }, []);

  return (
    <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
      {inmueble.content.map((row, index) => (
        <div className="col" key={index}>
          <div className="proyecto">
            <div className="album py-1 bg-body-tertiary">
              <p className="small text-muted mb-1">{row[0].tipoNegocio}</p>
              <img id="imagen" alt="Imagen del inmueble" src={URL.createObjectURL(
                                    base64StringToBlob(row[1], 'image/jpeg'))} class="img-thumbnail" />
              <div className="overlay">
                <p>Contact Name</p>
                <Link to={"/contact"}>
                  <i className="bi bi-person"></i>
                </Link>
              </div>
              <div className="container">
                <p className="small text-muted mb-1">
                  Dirección : {row[0].direccion}
                </p>
                <p className="small text-muted mb-1">
                  Características : {row[0].caracteristicas}
                </p>
                <p className="small text-muted mb-1">
                  Tipo de Inmueble : {row[0].tiposInmueble}
                </p>
              </div>
            </div>
            <div className="container">
              <hr className="featurette-divider" />
            </div>
          </div>
        </div>
      ))}
    </div>
  );
};
