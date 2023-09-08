import React, { useEffect } from 'react'
import { useState } from 'react'
import InmuebleService from '../services/InmuebleService'
import { Link } from "react-router-dom";
import { base64StringToBlob } from "blob-util";

export const ListPropiedades = () => {

    const [inmueble, setInmueble] = useState({ content: [] });

    useEffect(() => {
        InmuebleService.getInmuebleAll("0", "50")
            .then((res) => {
                setInmueble(res.data);
            })
            .catch((error) => {
                console.error(
                    "Error al obtener datos o crear la URL de la imagen:",
                    error
                );
            });

    }, []);

    return (
        <div className="album py-5 bg-body-tertiary">
            <div className="container">
                <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                    {inmueble.content.map((row, index) => (
                        <div className="col" key={index}>
                            <div className="album py-1 bg-body-tertiary">

                                <p className="small text-muted mb-1">{row[0].tipoNegocio}</p>
                                <img
                                    id="img"
                                    alt="Imagen de propiedad"
                                    src={URL.createObjectURL(
                                        base64StringToBlob(row[1], "image/jpeg")
                                    )}
                                    className="bd-placeholder-img card-img-top" width={500} height={300}
                                />

                                <div className="card-body mt-2">
                                    <ul className='list-group list-group-flush'>
                                        <li className="list-group-item">
                                            <strong>Tipo de Inmueble : </strong>{row[0].tiposInmueble}
                                        </li>
                                        <li className="list-group-item">
                                            <strong>Dirección : </strong>{row[0].direccion}
                                        </li>
                                        <li className="list-group-item">
                                            <strong>Características : </strong>{row[0].caracteristicas}
                                        </li>
                                        <li className="list-group-item">
                                            <strong>Precio : </strong>${row[0].valor}
                                        </li>
                                    </ul>
                                </div>
                                <div className='d-flex justify-content-end'>
                                    <button className='btn'>
                                        Comprar
                                    </button>
                                </div>

                            </div>
                            <div>
                                <hr className="featurette-divider" />
                            </div>

                        </div>
                    ))}
                    <Link to={"/home"} className='text-dark nav-link'>
                        <i className="bi bi-arrow-left-short"></i>Atrás
                    </Link>
                </div>
            </div>
        </div>
    )
}