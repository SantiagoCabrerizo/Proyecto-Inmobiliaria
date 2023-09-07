import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import InmuebleService from "../services/InmuebleService";
import { base64StringToBlob } from 'blob-util';


export const TestInmuebles = () => {
    const [inmueble, setInmueble] = useState({ content: [] });
    const [imageUrl, setImageUrl] = useState(""); // Estado para almacenar la URL de la imagen

    useEffect(() => {
        const formData = new FormData();
        InmuebleService.getInmuebleAll("0", "6")
            .then((res) => {
                setInmueble(res.data);
            })
            .catch((error) => {
                console.error("Error al obtener datos o crear la URL de la imagen:", error);
            });
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
                        <th>Imagen</th>
                    </tr>
                </thead>
                <tbody>
                    {inmueble.content.map((row, index) => (
                        <tr key={index}>
                            <td>{row[0].id}</td>
                            <td>{row[0].direccion}</td>
                            <td>{row[0].caracteristicas}</td>
                            <td>{row[0].dueño.nombre + " " + row[0].dueño.apellido}</td>
                            <td>{row[0].inquilino ? row[0].inquilino.nombre : 'Sin inquilino'}</td>
                            <td>{row[0].tiposInmueble}</td>
                            <td>{row[0].tipoNegocio}</td>
                            <td>{row[0].valor}</td>
                            <td>
                                <img id="imagen" alt="Imagen del inmueble" src={URL.createObjectURL(
                                    base64StringToBlob(row[1], 'image/jpeg'))}
                                    style={{
                                        width: '200px', // Ancho deseado
                                        height: '150px', // Alto deseado
                                    }} />
                            </td>
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