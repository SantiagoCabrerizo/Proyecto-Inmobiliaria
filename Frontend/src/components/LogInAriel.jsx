import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useForm } from "react-hook-form";
import LoginService from "../services/LoginService";
import { parse, stringify, toJSON, fromJSON } from "flatted";

export const LogIn = () => {
  const [token, setToken] = useState(""); // Usa useState aquí

  useEffect(() => {
    window.scrollTo(0, 0);
  });

  const date = new Date().getFullYear();
  const navigate = useNavigate();

  const {
    register,
    handleSubmit,
    formState: { errors },
    watch,
  } = useForm();

  const onSubmit = async (data) => {
    try {
      const formData = new FormData();
      formData.append("username", data.username);
      formData.append("password", data.password);

      const response = await LoginService.loginUsers(formData);
      const receivedToken = response.data.token; // Accede directamente a response.data.token
      setToken(receivedToken); // Almacena el token en el estado
      console.log("Token recibido:", receivedToken);
      LoginService.loginUsers(data).then(navigate("/"));
    } catch (error) {
      console.error("Error:", error);
      // Muestra un mensaje de error en caso de error en la solicitud
    }
  };

  return (
    <div className="container mt-4">
      <div className="row justify-content-center text-center">
        <div className="col-md-4">
          <form onSubmit={handleSubmit(onSubmit)}>
            <p className="h3 mb-3 fw-normal">Iniciar sesión</p>

            <div className="form-floating mb-3">
              <input
                type="email"
                className="form-control"
                id="floatingInputEmail"
                placeholder=""
                {...register("username", {
                  required: {
                    value: true,
                    message: "Ingresar email",
                  },
                  pattern: {
                    value: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
                    message: "Email inválido",
                  },
                })}
              />
              {errors.username && (
                <div className="alert alert-danger mt-2 py-2">
                  {errors.username.message}
                </div>
              )}
              <label htmlFor="floatingInputEmail">Email</label>
            </div>

            <div className="form-floating mb-3">
              <input
                type="password"
                className="form-control"
                id="floatingPassword"
                placeholder="Password"
                {...register("password", {
                  required: {
                    value: true,
                    message: "Ingresar contraseña",
                  },
                })}
              />
              {errors.password && (
                <div className="alert alert-danger mt-2 py-2">
                  {errors.password.message}
                </div>
              )}
              <label htmlFor="floatingPassword">Contraseña</label>
            </div>

            <div className="d-grid gap-2 mt-4">
              <button className="btn btn-outline-primary py-2" type="submit">
                Ingresar
              </button>
              <Link to={"/"} className="btn btn-outline-secondary py-2 me-1">
                Cancelar
              </Link>
            </div>

            <hr className="featurette-divider" />

            <p className="mb-3 fs-6 fw-normal">
              ¿No tienes una cuenta?
              <span>
                {" "}
                <Link
                  to={"/registro"}
                  className="link-underline link-underline-opacity-0"
                >
                  Regístrate
                </Link>
              </span>
            </p>

            <p className="mt-4 mb-4 text-body-secondary">&copy; {date}</p>
          </form>
        </div>
      </div>
    </div>
  );
};
