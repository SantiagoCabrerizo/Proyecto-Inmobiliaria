import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';
import UserService from "../services/UserService";

export const HeaderLogueado = () => {

    const [user, setUser] = useState([])

    useEffect(() => {
        UserService.getByIdWithToken(localStorage.getItem('sub'), localStorage.getItem('token'))
            .then(res => setUser(res.data))
    }, [])

    return (
        <header>
            <nav className="navbar navbar-expand-md border-bottom">
                <div className="container-fluid">
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar-toggler" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbar-toggler">

                        <Link to="/home" className='navbar-brand'>
                            <img src="public/logo_header.jpeg" width={150} alt="Logo de la página web" />
                        </Link>

                        <ul className="navbar-nav d-flex align-items-center" >
                            <li className="nav-item dropdown">
                                <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    <strong>
                                        {user.nombre} {user.apellido} <i className="bi bi-person-circle"></i>
                                    </strong>
                                </a>
                                <ul className="dropdown-menu dropdown-menu-lg-end">
                                    <li><Link to={"/perfil"} className='dropdown-item'>
                                        Ver perfil
                                    </Link></li>
                                    <li><a className="dropdown-item" href="#contacto">Contacto</a></li>
                                    <li><hr className="dropdown-divider" /></li>
                                    <li><Link to={"/logout"} className='dropdown-item'>
                                        Cerrar Sesión
                                    </Link></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header >
    )
}