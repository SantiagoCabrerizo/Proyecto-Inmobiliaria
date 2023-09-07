import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import InmuebleService from "../services/InmuebleService";
import UserService from "../services/UserService";

export const Project = () => {
    const [inmueble, setInmueble] = useState({ content: [] });

    const [user, setUser] = useState([])

    useEffect(() => {
        InmuebleService.getInmuebleAll()
            .then((res) => setInmueble(res.data));

        UserService.getByIdWithToken(localStorage.getItem('sub'), localStorage.getItem('token'))
            .then(res => setUser(res.data))

    }, []);

    return (
        <div>

            <tbody>
                {inmueble.content.map((row, index) => (
                    <div className="proyecto" key={index}>
                        <div className="album py-1 bg-body-tertiary">
                            <p className="small text-muted mb-1"> {row[0].tipoNegocio} </p>
                            <img src="https://api-prod.corelogic.com/trestle/Media/SEFMIAMI.SEFMIAMI_MIAMI/Property/PHOTO-jpeg/1040219637/1/MzI0MC8yMDI5LzY2/NjYvNTQ1OC8xNjkxMTE4NDAz/zPAmPS5zlfKHc9ewjqenKHsgd8eilllx9fhnaUA_zi8" alt="Listing A11417393 Photo 0" />
                            <div className="overlay">
                                <p>{user.nombre}</p>
                                <Link to={"/contact"}>
                                    <i className="bi bi-info-circle"></i>
                                </Link>
                            </div>
                            <div classsName="container" >
                                <p className="small text-muted mb-1">Direccion : {row[0].direccion} </p>
                                <p className="small text-muted mb-1">Caracteristicas : {row[0].caracteristicas} </p>
                                <p className="small text-muted mb-1">Tipo de Inmueble : {row[0].tiposInmueble} </p>
                            </div>
                        </div>
                        <div classsName="container" >
                            <hr className='featurette-divider' />
                        </div>
                    </div>
                ))}
            </tbody>

        </div>
    );
}
