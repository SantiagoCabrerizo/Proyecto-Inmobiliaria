import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import InmuebleService from "../services/InmuebleService";
import { base64StringToBlob } from "blob-util";
import UserService from "../services/UserService";

export const Projects = () => {

    const handleClick = (inmuebleId) => {
        // Al hacer clic en el enlace, se ejecutará esta función.
        localStorage.setItem("selectedInmuebleId", inmuebleId);
    };
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
                            <div className="proyecto">
                                <div className="album py-1 bg-body-tertiary">
                                    <p className="small text-muted mb-1">{row[0].tipoNegocio}</p>
                                    <img
                                        id="imagen"
                                        alt="Imagen del inmueble"
                                        src={URL.createObjectURL(
                                            base64StringToBlob(row[1], "image/jpeg")
                                        )}
                                        className="bd-placeholder-img card-img-top" width={500} height={300}
                                    />
                                    <div className="overlay">
                                        <Link to={"/contact"}>
                                            <i
                                                className="bi bi-info-circle"
                                                onClick={() => handleClick(row[0].id)} // Cambiado el evento onClick
                                            ></i>
                                        </Link>
                                    </div>
                                    <div className="card-body mt-2">
                                        <p className="small text-muted mb-1">
                                            Dirección : {row[0].direccion}
                                        </p>
                                        <p className="small text-muted mb-1">
                                            Tipo de Inmueble : ${row[0].valor}
                                        </p>
                                    </div>
                                </div>
                                <div>
                                    <hr className="featurette-divider" />
                                </div>
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
};