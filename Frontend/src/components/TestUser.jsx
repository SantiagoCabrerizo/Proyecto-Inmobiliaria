import React, { useEffect, useState } from 'react'
import UserService from '../services/UserService';
import { Link } from 'react-router-dom';

export const TestUser = () => {

    const [user, setUser] = useState([]);

    useEffect(() => {
        UserService.getUsers(localStorage.getItem('token'))
            .then(res => setUser(res.data))
    }, [])

    return (
        <div>
            <table className='table table-hover container mt-5 mb-5'>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Apellido</th>
                        <th>Email</th>
                        <th>Dni</th>
                        <th>Rol</th>
                    </tr>
                </thead>
                <tbody>
                    {user.map(user =>
                        <tr key={user.id}>
                            <td>{user.nombre}</td>
                            <td>{user.apellido}</td>
                            <td>{user.email}</td>
                            <td>{user.dni}</td>
                            <td>{user.rol}</td>
                            <td><Link to={`/usuarios/${user.id}`}>Detalles</Link></td>
                        </tr>
                    )}
                </tbody>
            </table>


        </div>
    )
}