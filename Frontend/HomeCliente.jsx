import React from "react";

export const HomeCliente = () => {
  const date = new Date().getFullYear();
  return (
    <div className="container mt-4">
      <div className="row justify-content-center text-center">
        <div className="col-md-6">
          <h1>Bienvenido a la Web MR. HOUSE</h1>
          <p>Encuentra tu próximo hogar o gestiona tus alquileres aquí.</p>
        </div>
      </div>
      <div className="row justify-content-center">
        <div className="col-md-6 text-center mb-4">
          <div className="card">
            <div className="card-body">
              <h2>Buscar Propiedad</h2>
              <p>Encuentra la propiedad perfecta para ti.</p>
              <a
                href="/buscar-propiedad"
                className="btn btn-outline-primary py-2"
              >
                Buscar Propiedades
              </a>
            </div>
          </div>
        </div>
      </div>
      <div className="row justify-content-center">
        <div className="col-md-6 text-center">
          <div className="card">
            <div className="card-body">
              <h2>Mis Alquileres</h2>
              <p>Administra tus alquileres actuales y anteriores aquí.</p>
              <a
                href="/cards_alquileres"
                className="btn btn-outline-primary py-2"
              >
                Ver Alquileres
              </a>
            </div>
          </div>
        </div>
      </div>
      <hr className="featurette-divider" />
      <p className="mt-4 mb-4 text-body-secondary">&copy; {date}</p>
    </div>
  );
};
