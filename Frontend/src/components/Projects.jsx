import React from 'react'
import { Project } from './Project'

export const Projects = () => {
    return (
        <>
            <section id="venta" className="proyectos-recientes seccion-clara d-flex flex-column">
                <h2 className="seccion-titulo texto-negro">Ventas destacadas</h2>
                <h3 className="seccion-descripcion">
                    <i className="bi bi-geo-alt-fill me-1"></i>
                    Estas son algunas de las propiedades dentro de tu zona...
                </h3>


                <div className="album py-5 bg-body-tertiary">
                    <div className="container">
                        <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                            <Project />
                            <Project />
                            <Project />
                            <Project />
                            <Project />
                            <Project />
                        </div>

                    </div>
                </div>

                <a href="https://github.com/" target="_blank" rel="noopener noreferrer">
                    <button type="button" className="btn btn-dark">
                        Ver más
                        <i className="bi bi-arrow-right-circle ms-2"></i>
                    </button>
                </a>

            </section>

        </>
    )
}