import React from "react";
import { Link, useNavigate } from "react-router-dom";
import { useForm } from "react-hook-form";
import UserService from "../services/UserService";
import { useState } from "react";

export const FormInmueble = () => {
  const date = new Date().getFullYear();
  const navigate = useNavigate();
  const [selectedImage, setSelectedImage] = useState(null); {/*Se inicia en null hasta que se selecciona una imagen y el onChange se actualiza
 */}

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();

  const onSubmit = (data) => {
    const { ...formData } = data;
    formData.foto =selectedImage;{/*Captura la imagen y la almacena en selectedImage */}
    console.log(formData);
    UserService.createInmueble(formData).then(navigate("/inmueble"));
  };

  /* 
  Direccion
  Caracteristicas
  *dueño
  Tipo de negocio
  precio
  tipo de inmueble
  imagen
  */

  return (
    <div className="container mt-4">
      <div className="row justify-content-center text-center">
        <div className="col-md-4">
          <form onSubmit={handleSubmit(onSubmit)} encType="multipart/form-data"> {/*con encType el form se configura para
          enviar la imagen */}
            <p className="h3 mb-3 fw-normal">Nuevo Inmueble</p>
            {/* Direccion */}
            <div className="form-floating mb-2">
              <input
                type="text"
                className="form-control"
                id="floatingInputName"
                placeholder=""
                {...register("direccion", {
                  required: {
                    value: true,
                    message: "La direccion es obligatorio",
                  },
                  minLength: {
                    value: 2,
                    message: "La direccion debe tener al menos 2 caracteres",
                  },
                })}
              />

              {errors.direccion && (
                <div className="alert alert-danger mt-2 py-2">
                  {errors.direccion.message}
                </div>
              )}
              <label htmlFor="floatingInputName">Direccion</label>
            </div>
            {/* Caracteristicas */}
            <div className="form-floating mb-2">
              <input
                type="text"
                className="form-control"
                id="floatingInputName"
                placeholder=""
                {...register("caracteristicas", {
                  required: {
                    value: true,
                    message: "caracteristicas es obligatorio",
                  },
                  minLength: {
                    value: 2,
                    message:
                      "Las caracteristicas debe tener al menos 2 caracteres",
                  },
                })}
              />

              {errors.caracteristicas && (
                <div className="alert alert-danger mt-2 py-2">
                  {errors.caracteristicas.message}
                </div>
              )}
              <label htmlFor="floatingInputName">Caracteristicas</label>
            </div>

            {/* DUEÑO NOOOOOO    aca va un select alquiler o venta */}

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

            {/* Precio */}
            <div className="form-floating mb-2">
              <input
                type="text"
                className="form-control"
                id="floatingInputName"
                placeholder=""
                {...register("precio", {
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

              {errors.precio && (
                <div className="alert alert-danger mt-2 py-2">
                  {errors.precio.message}
                </div>
              )}
              <label htmlFor="floatingInputName">Precio</label>
            </div>

            {/* <div className="form-floating mb-2">
              <input
                type="text"
                className="form-control"
                id="floatingInputName"
                placeholder=""
                {...register("duenio", {
                  required: {
                    value: true,
                    message: "El dueño es obligatorio",
                  },
                  minLength: {
                    value: 2,
                    message: "El dueño debe tener al menos 2 caracteres",
                  },
                })}
              /> 
              {errors.duenio && (
                <div className="alert alert-danger mt-2 py-2">
                  {errors.duenio.message}
                </div>
              )}
              <label htmlFor="floatingInputName">Dueño</label>
            </div> 
            */}
            {/* tipo na */}
            <div className="form-floating mb-3">
              <select
                {...register("tipo", {
                  required: {
                    value: true,
                    message: "El tipo de inmueble es obligatorio",
                  },
                })}
                className="form-select"
                id="tipo"
                aria-label="Floating label select example"
              >
                <option value="CASA">Casa</option>
                <option value="DEPTO">Departamento</option>
                <option value="OFI">Oficina</option>
              </select>
              {errors.tipo && (
                <div className="alert alert-danger mt-2 py-2">
                  {errors.tipo.message}
                </div>
              )}
              <label htmlFor="tipo">Tipo de inmueble</label>
            </div>

            {/* Imagen */}

            <div className="input-group">
              <input
                type="file"
                {...register("foto")}
                className="form-control"
                id="inputImagen"
                aria-describedby="inputGroupFileAddon04"
                aria-label="Upload"
                onChange={(e)=> setSelectedImage(e.target.files[0])}
              />

              <button
                className="btn btn-outline-secondary"
                type="submit"
                id="inputGroupFileAddon04"
              >
                Subir
              </button>
            </div>
            {/* -------------------------- */}
            <div className="d-grid gap-2 mt-4">
              <button className="btn btn-outline-primary py-2" type="submit">
                Registrar
              </button>
              <Link to={"/"} className="btn btn-outline-secondary py-2 me-1">
                Cancelar
              </Link>
            </div>
            <div className="container mt-4"></div>
          </form>
        </div>
      </div>
    </div>
  );
};