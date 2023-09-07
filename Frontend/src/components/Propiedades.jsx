import React, { useEffect, useState } from 'react'
import InmuebleService from '../services/InmuebleService'
import { Link } from 'react-router-dom';

export const Propiedades = () => {
    const [inmuebles, setInmueble] = useState([])

    useEffect(() => {
        InmuebleService.getInmuebleByUser(localStorage.getItem('token'))
            .then(res => setInmueble(res.data))
    }, [])

    return (
        <div className='container mt-4 mb-4'>
            <h1 className='text-center mb-4'>Lista de propiedades</h1>

            {inmuebles.map((inmueble) => (
                <div className="col" key={inmueble}>
                    <div className="proyecto">
                        <div className="album py-1 bg-body-tertiary">
                            <ul className="text-center">
                                <li className="list-group-item"><strong>Dirección: </strong>{inmueble.direccion}</li>
                                <li className="list-group-item"><strong>Características: </strong>{inmueble.caracteristicas}</li>
                                <li className="list-group-item"><strong>Tipo de Inmueble: </strong>{inmueble.tiposInmueble}</li>
                                <li className="list-group-item"><strong>Valor: </strong>{inmueble.valor}</li>
                            </ul>
                        </div>
                        <div>
                            <hr className="featurette-divider" />
                        </div>
                    </div>
                </div>
            ))}

            <div className="mt-2">
                <Link to={"/home"}>
                    <i className="bi bi-arrow-left text-dark"></i>
                </Link>
            </div>
        </div>
    )
}
