import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import InmuebleService from "../services/InmuebleService";

export const TestInmuebles = () => {
    const [inmueble, setInmueble] = useState({ content: [] });

    useEffect(() => {
        InmuebleService.getInmuebleAll()
            .then((res) => setInmueble(res.data));
    }, []);

    return (
        <div>
            <table className="table table-hover container mt-5 mb-5">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Direccion</th>
                        <th>Caracteristicas</th>
                        <th>Dueño</th>
                        <th>Inquilino</th>
                        <th>tiposInmueble</th>
                        <th>tipoNegocio</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    {inmueble.content.map((row, index) => (
                        <tr key={index}>
                            <td>{row[0].id}</td> {/* Acceder a la propiedad id dentro de la posición 0 de cada inmueble */}
                            <td>{row[0].direccion}</td> {/* Acceder a la propiedad direccion dentro de la posición 0 de cada inmueble */}
                            <td>{row[0].caracteristicas}</td> {/* Acceder a la propiedad caracteristicas dentro de la posición 0 de cada inmueble */}
                            <td>{row[0].dueño.nombre + " " + row[0].dueño.apellido}</td> {/* Acceder a la propiedad nombre del dueño dentro de la posición 0 de cada inmueble */}
                            <td>{row[0].inquilino ? row[0].inquilino.nombre : 'Sin inquilino'}</td> {/* Acceder a la propiedad nombre del inquilino (si está presente) dentro de la posición 0 de cada inmueble */}
                            <td>{row[0].tiposInmueble}</td> {/* Acceder a la propiedad tiposInmueble dentro de la posición 0 de cada inmueble */}
                            <td>{row[0].tipoNegocio}</td> {/* Acceder a la propiedad tipoNegocio dentro de la posición 0 de cada inmueble */}
                            <td>{row[0].valor}</td> {/* Acceder a la propiedad valor dentro de la posición 0 de cada inmueble */}
                            <td>
                                <Link to={`/inmueble/${row[0].id}`}>Detalles</Link>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};