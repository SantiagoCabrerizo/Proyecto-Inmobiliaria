import React from "react";
import { Link, useNavigate } from "react-router-dom";
import { useForm } from "react-hook-form";
import InmuebleService from "../services/InmuebleService";

export const FormInmueble = () => {
  const date = new Date().getFullYear();
  const navigate = useNavigate();

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();

  const onSubmit = (data) => {
    const formData = new FormData();
    formData.append("direccion", data.direccion);
    formData.append("caracteristicas", data.caracteristicas);
    formData.append("tipoNegocio", data.tipo_neg);
    formData.append("tiposInmueble", data.tiposInmueble);
    formData.append("valor", data.valor);
    formData.append("foto", data.inputImagen[0]);

    try {
      InmuebleService.ingresarInmueble(formData, localStorage.getItem('token'));
      navigate("/home")
    } catch (error) {
      console.log(error)
    }
  };

  return (
    <div className="container mt-4 mb-5">
      <div className="row justify-content-center text-center">
        <div className="col-md-4">
          <form onSubmit={handleSubmit(onSubmit)}>
            <p className="h3 mb-3 fw-normal">Nuevo Inmueble</p>

            <div className="form-floating mb-2">
              <input
                type="text"
                className="form-control"
                id="direccion"
                placeholder=""
                {...register("direccion", {
                  required: {
                    value: true,
                    message: "La dirección es obligatoria",
                  },
                  minLength: {
                    value: 2,
                    message: "La dirección debe tener al menos 2 caracteres",
                  },
                })}
              />

              {errors.direccion && (
                <div className="alert alert-danger mt-2 py-2">
                  {errors.direccion.message}
                </div>
              )}
              <label htmlFor="direccion">Dirección</label>
            </div>

            <div className="form-floating mb-2">
              <input
                type="text"
                className="form-control"
                id="caracteristicas"
                placeholder=""
                {...register("caracteristicas", {
                  required: {
                    value: true,
                    message: "Características son obligatorias",
                  },
                  minLength: {
                    value: 2,
                    message: "Características deben tener al menos 2 caracteres",
                  },
                })}
              />

              {errors.caracteristicas && (
                <div className="alert alert-danger mt-2 py-2">
                  {errors.caracteristicas.message}
                </div>
              )}
              <label htmlFor="caracteristicas">Características</label>
            </div>

            <div className="form-floating mb-3">
              <select
                className="form-select"
                id="tipo_neg"
                aria-label="Floating label select example"
                {...register("tipo_neg", {
                  required: {
                    value: true,
                    message: "El tipo de negocio es obligatorio",
                  },
                })}
              >
                <option value="VENTA">Venta</option>
                <option value="ALQUILER">Alquiler</option>
              </select>
              {errors.tipo_neg && (
                <div className="alert alert-danger mt-2 py-2">
                  {errors.tipo_neg.message}
                </div>
              )}
              <label htmlFor="tipo_neg">Tipo de negocio</label>
            </div>

            <div className="form-floating mb-2">
              <input
                type="text"
                className="form-control"
                id="valor"
                placeholder=""
                {...register("valor", {
                  required: {
                    value: true,
                    message: "El precio es obligatorio",
                  },
                  minLength: {
                    value: 2,
                    message: "El precio debe tener al menos 2 caracteres",
                  },
                })}
              />

              {errors.valor && (
                <div className="alert alert-danger mt-2 py-2">
                  {errors.valor.message}
                </div>
              )}
              <label htmlFor="valor">Precio</label>
            </div>

            <div className="form-floating mb-3">
              <select
                className="form-select"
                id="tiposInmueble"
                aria-label="Floating label select example"
                {...register("tiposInmueble", {
                  required: {
                    value: true,
                    message: "El tipo de inmueble es obligatorio",
                  },
                })}
              >
                <option value="CASA">Casa</option>
                <option value="DEPTO">Departamento</option>
                <option value="OFI">Oficina</option>
              </select>
              {errors.tiposInmueble && (
                <div className="alert alert-danger mt-2 py-2">
                  {errors.tiposInmueble.message}
                </div>
              )}
              <label htmlFor="tiposInmueble">Tipo de inmueble</label>
            </div>

            <div className="input-group">
              <input
                type="file"
                className="form-control"
                id="inputImagen"
                aria-describedby="inputGroupFileAddon04"
                aria-label="Upload"
                {...register("inputImagen")}
              />

              <button
                className="btn btn-outline-secondary"
                type="button"
                id="inputGroupFileAddon04"
              >
                Subir
              </button>
            </div>

            <div className="d-grid gap-2 mt-4">
              <button className="btn btn-outline-primary py-2" type="submit">
                Registrar
              </button>
              <Link to={"/home"} className="btn btn-outline-secondary py-2 me-1">
                Cancelar
              </Link>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};