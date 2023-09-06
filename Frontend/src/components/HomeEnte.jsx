/* import React from "react";
import { Link } from 'react-router-dom';

export const HomeEnte = () => {
  const date = new Date().getFullYear();
  return (
    <div className="container mt-4">
      <div className="row justify-content-center text-center">
        <div className="col-md-6">
          <h1>Mis Gestiones</h1>
          <p class="fs-1 fw-medium mb-4 mt-3">Gestiona tus propiedades</p>
        </div>
      </div>
      <div>
            <div className="container shadow p-3 mb-5 bg-body-tertiary rounded mt-3">
                <div className="row featurette">
                    <div className="col-md-7 order-md-2">
                        <h2 className="featurette-heading fw-normal lh-1">Mis Gestiones</h2>
                        
                        <a
                href="/registro_i"
                className="btn btn-outline-primary py-2"
              >
                Nueva Propiedad
              </a>
              <div>

              </div>
              <a
                href="/mis-propiedades"
                className="btn btn-outline-primary py-2"
              >
                Ver Propiedades
              </a>
                    </div>
                    <div className="col-md-5 overflow-auto">
                        <img className="rounded" width={500} src="https://api-prod.corelogic.com/trestle/Media/SEFMIAMI.SEFMIAMI_MIAMI/Property/PHOTO-jpeg/1040219637/1/MzI0MC8yMDI5LzY2/NjYvNTQ1OC8xNjkxMTE4NDAz/zPAmPS5zlfKHc9ewjqenKHsgd8eilllx9fhnaUA_zi8" alt="Listing A11417393 Photo 0" />
                    </div>
                </div>

                <div className='mt-3'>
                    <Link to={"/"}>
                        <i className="bi bi-arrow-left"></i>
                    </Link>
                </div>
            </div>

        </div>
      
      <div className="row justify-content-center">
        <div className="col-md-6 text-center mb-4">


      <img class="hero-inferior-imagen img-fluid pb-4" src="public/logo_header.jpeg" alt="imagen hero logo"></img>
      </div>
      </div>
      <hr className="featurette-divider" />
      <p className="mt-4 mb-4 text-body-secondary">&copy; {date}</p>
    </div>
  );
}; 
 */
import React from "react";
import { Link } from "react-router-dom";

export const HomeEnte = () => {
    const date = new Date().getFullYear();
    return (
        <div>
            <section className="proyectos-recientes seccion-clara d-flex flex-column">
                <div className="row row-cols-1 row-cols-sm-2 row-cols-md-2 g-2">
                    <div className="proyecto">
                        <img
                            src="https://api-prod.corelogic.com/trestle/Media/SEFMIAMI.SEFMIAMI_MIAMI/Property/PHOTO-jpeg/1040219637/1/MzI0MC8yMDI5LzY2/NjYvNTQ1OC8xNjkxMTE4NDAz/zPAmPS5zlfKHc9ewjqenKHsgd8eilllx9fhnaUA_zi8"
                            alt="Listing A11417393 Photo 0"
                        />
                        <div className="overlay">
                            <p>Nueva Propiedad</p>
                            <Link to={"/registro_i"}>
                                <i class="bi bi-house-door"></i>
                            </Link>
                        </div>
                    </div>

                    <div className="proyecto">
                        <img
                            src="https://api-prod.corelogic.com/trestle/Media/SEFMIAMI.SEFMIAMI_MIAMI/Property/PHOTO-jpeg/1040219637/1/MzI0MC8yMDI5LzY2/NjYvNTQ1OC8xNjkxMTE4NDAz/zPAmPS5zlfKHc9ewjqenKHsgd8eilllx9fhnaUA_zi8"
                            alt="Listing A11417393 Photo 0"
                        />
                        <div className="overlay">
                            <p>Ver Propiedades</p>
                            <Link to={"/home"}>
                                <i class="bi bi-house-door"></i>
                            </Link>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    );
};