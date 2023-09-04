import React, { useState } from "react";
import axios from "axios";

const Login = () => {
  const [formData, setFormData] = useState({
    username: "",
    password: "",
  });
  const [token, setToken] = useState(null); // Estado para almacenar el token

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("/api/login", formData); // Envia datos al servidor
      const { token } = response.data;

      // Almacena el token JWT en el estado local
      setToken(token);

      // Limpia el formulario
      setFormData({
        username: "",
        password: "",
      });
    } catch (error) {
      console.error("Error al iniciar sesión", error);
    }
  };

  return (
    <div>
      <h2>Iniciar Sesión</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Usuario:</label>
          <input
            type="text"
            name="username"
            value={formData.username}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Contraseña:</label>
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
          />
        </div>
        <button type="submit">Iniciar Sesión</button>
      </form>
      {token && <p>Tu token JWT: {token}</p>}
    </div>
  );
};

export default Login;
