import React from "react";
import { Link } from "react-router-dom";

export const HomeClient = () => {
    const date = new Date().getFullYear();
    return (
        <div>
            <section className="proyectos-recientes seccion-clara d-flex flex-column">
                <div className="row row-cols-1 row-cols-sm-2 row-cols-md-2 g-2">
                    <div className="proyecto">
                        <img
                            src="https://api-prod.corelogic.com/trestle/Media/SEFMIAMI.SEFMIAMI_MIAMI/Property/PHOTO-jpeg/1040219637/1/MzI0MC8yMDI5LzY2/NjYvNTQ1OC8xNjkxMTE4NDAz/zPAmPS5zlfKHc9ewjqenKHsgd8eilllx9fhnaUA_zi8"
                            alt="Listing A11417393 Photo 0"
                        />
                        <div className="overlay">
                            <p>Buscar Propiedad</p>
                            <Link to={"/buscar_prop"}>
                                <i class="bi bi-house-door"></i>
                            </Link>
                        </div>
                    </div>

                    <div className="proyecto">
                        <img
                            src="https://api-prod.corelogic.com/trestle/Media/SEFMIAMI.SEFMIAMI_MIAMI/Property/PHOTO-jpeg/1040219637/1/MzI0MC8yMDI5LzY2/NjYvNTQ1OC8xNjkxMTE4NDAz/zPAmPS5zlfKHc9ewjqenKHsgd8eilllx9fhnaUA_zi8"
                            alt="Listing A11417393 Photo 0"
                        />
                        <div className="overlay">
                            <p>Mis Alquileres</p>
                            <Link to={"/home"}>
                                <i class="bi bi-house-door"></i>
                            </Link>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    );
};