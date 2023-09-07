import React from 'react'
import { Link } from 'react-router-dom';

export const Footer = () => {

    const date = new Date().getFullYear()

    const handleScrollToTop = () => {
        window.scrollTo({ top: 0, behavior: "smooth" })
    }

    return (
        <div>
            <footer id="contacto" className="seccion-oscura d-flex flex-column align-items-center justify-content-center">
                {/*<img className="footer-icono" src="imagenes/diseno-de-respuesta.png" alt="Logo del portafolio" />*/}

                <p className="container d-flex justify-content-center" alt="Logo del portafolio">
                    <i className="bi bi-code-square"></i>
                </p>

                <p className="footer-text text-center">
                    ¿Necesitas rapidez y eficacia en tus negocios?<br />Trabajemos juntos </p>

                <div className="iconos-redes-sociales d-flex flex-wrap align-items-center justify-content-center">
                    <a href="" target="_blank" rel="noopener noreferrer">
                        <i className="bi bi-twitter"></i>
                    </a>
                    <a href="https://github.com/SantiagoCabrerizo/Proyecto-Inmobiliaria" target="_blank" rel="noopener noreferrer">
                        <i className="bi bi-github"></i>
                    </a>
                    <a href="" target="_blank" rel="noopener noreferrer">
                        <i className="bi bi-linkedin"></i>
                    </a>
                    <a href="" target="_blank" rel="noopener noreferrer">
                        <i className="bi bi-instagram"></i>
                    </a>
                    <a href="" target="_blank" rel="noopener noreferrer">
                        <i className="bi bi-envelope"></i>
                    </a>
                </div>

                <div className="derechos-de-autor">&#169; Creado por Equipo 2 - {date}</div>
                {
                    /*
                     <Link to={"/usuarios"} className='derechos-de-autor'>
                                    Listado usuarios (ADMIN)
                                </Link>
                    */
                }
                <button className="btn btn-outline-light fs-5" id='button-handleTop' onClick={handleScrollToTop}>
                    <i className="bi bi-arrow-up"></i>
                </button>


            </footer>
        </div>
    )
}