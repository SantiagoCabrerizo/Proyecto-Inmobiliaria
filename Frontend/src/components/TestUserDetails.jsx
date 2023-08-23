import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import UserService from '../services/UserService'

export const TestUserDetails = () => {

    const [user, setUser] = useState([])
    const { id } = useParams()
    const navigate = useNavigate()

    useEffect(()=>{
        UserService.getById(id)
            .then(
                res => setUser(res.data)
            )
    },[id])

    const deleteUser = () => {
        UserService.deleteUser(id)
            .then(
                navigate("/usuarios")
            )
    }

    return (
        <div>
            <table className='table table-hover container'>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Email</th>
                        <th>DNI</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>{user.id}</td>
                        <td>{user.nombre}</td>
                        <td>{user.email}</td>
                        <td>{user.dni}</td>
                        <td><button className='btn btn-danger' onClick={()=>deleteUser(id)}>Eliminar</button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    )
}