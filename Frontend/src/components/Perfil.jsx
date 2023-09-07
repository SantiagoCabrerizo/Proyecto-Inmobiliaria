import React, { useEffect, useState } from "react";
import UserService from "../services/UserService";
import { Link } from 'react-router-dom';

export const Perfil = () => {
    const [user, setUser] = useState([]);

    useEffect(() => {
        UserService.getByIdWithToken(localStorage.getItem('sub'), localStorage.getItem('token'))
            .then(res => setUser(res.data))

    }, [])
    return (
        <div>
            <div className="modal modal-sheet position-static d-block bg-body-secondary p-4 py-md-5" tabIndex="-1" role="dialog" id="modalSheet">
                <div className="modal-dialog">
                    <div className="modal-content rounded-4 shadow">
                        <div className="modal-header border-bottom-0 justify-content-center">
                            <h1 className="modal-title fs-3">Mi perfil</h1>
                        </div>
                        <div className="modal-body py-0">

                            <ul className="list-group list-group-flush">
                                <li className="list-group-item"><strong>Nombre: </strong>{user.nombre}</li>
                                <li className="list-group-item"><strong>Apellido: </strong>{user.apellido}</li>
                                <li className="list-group-item"><strong>Email: </strong>{user.email}</li>
                                <li className="list-group-item"><strong>DNI: </strong>{user.dni}</li>
                                <li className="list-group-item"></li>
                            </ul>

                        </div>
                        <div className="modal-footer flex-column align-items-stretch w-100 gap-2 pb-3 border-top-0">
                            <Link to={"/home"} className="btn btn-secondary">
                                Volver
                            </Link>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    )
}