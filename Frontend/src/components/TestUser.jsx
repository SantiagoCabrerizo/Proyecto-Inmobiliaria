import React, { useEffect, useState } from 'react'
import UserService from '../services/UserService';

export const TestUser = () => {

    const [user, setUser] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/api/usuarios")
            .then(res => res.json())
            .then(data => setUser(data))

    }, [])

    return (
        <div>
            <table className='table table-hover'>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th>DNI</th>
                    </tr>
                </thead>
                <tbody>
                    {user.map(user =>
                        <tr key={user.id}>
                            <td>Nombre aqui</td>
                        </tr>
                    )}
                </tbody>
            </table>


        </div>
    )
}