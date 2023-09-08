import React, { useState, useEffect } from "react";
import InmuebleService from "../services/InmuebleService";
import { base64StringToBlob } from "blob-util";
import { Link } from 'react-router-dom';

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
        <div className="container mt-5 mb-5" style={{ width: "500px" }} >
            <div className="card">
                <img
                    src={`data:image/png;base64,${inmueble[0][1]}`}
                    className="card-img-top"
                    alt="Imagen del inmueble"
                />
            </div>

            <div className="card-body">
                <h5 className="card-title display-6 m-2">Detalles del Inmueble</h5>
                <div className="card-body text-start">
                    <ul className="list-group list-group-flush">
                        <li className="list-group-item"><strong>Tipo de Inmueble: </strong>{inmueble[0][0].tiposInmueble}</li>
                        <li className="list-group-item"><strong>Dirección: </strong>{inmueble[0][0].direccion}</li>
                        <li className="list-group-item"><strong>Características: </strong>{inmueble[0][0].caracteristicas}</li>
                        <li className="list-group-item"><strong>Valor: </strong>${inmueble[0][0].valor}</li>
                    </ul>
                </div>
                <div className="mt-2">
                    <Link to={"/"}>
                        <i className="bi bi-arrow-left text-dark"></i>
                    </Link>
                </div>

            </div>
        </div>
    );
};