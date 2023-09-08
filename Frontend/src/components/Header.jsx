import React from "react";
import { Link } from 'react-router-dom';

export const Header = () => {

  return (
    <header>
      <nav className="navbar navbar-expand-md border-bottom">
        <div className="container-fluid">
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar-toggler" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbar-toggler">

            <Link to="/" className='navbar-brand'>
              <img src="public/logo_header.jpeg" width={150} alt="Logo de la página web" />
            </Link>

            <ul className="navbar-nav d-flex align-items-center" >
              <li className="nav-item">
                <a className="nav-link" href='#venta' >Ventas</a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="#nosotros">Nosotros</a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="#contacto">Contacto</a>
              </li>
              <li className="nav-item">
                <Link to={"/registro"} className='nav-link active'>
                  Registrarse
                </Link>
              </li>
              <li>
                <Link to={"/login"} className='nav-link active'>
                  Ingresar
                </Link>
              </li>
            </ul>

          </div>
        </div>
      </nav>
    </header >
  )
}
