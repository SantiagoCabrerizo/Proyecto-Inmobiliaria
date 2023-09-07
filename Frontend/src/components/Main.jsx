import React, { useEffect } from 'react'
import { About } from './About';
import { Projects } from './Projects';
import { Link } from 'react-router-dom';

export const Main = () => {

    useEffect(() => {
        window.scrollTo(0, 0)
    })

    return (
        <div>

            <div id="myCarousel" className="carousel slide mb-6" data-bs-ride="carousel">
                <div className="carousel-indicators mb-0">
                    <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" className="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
                </div>
                <div className="carousel-inner">
                    <div className="carousel-item active">
                        <img src='public/main1.jpg' alt='Primer img' className="bd-placeholder-img" width={"auto"} aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false" />
                        <div className="container">
                            <div className="carousel-caption bg-dark bg-opacity-50 text-white start-0 end-0 bottom-0">
                                <p className='fs-1 fw-medium mb-4 mt-3'>Encontrá la propiedad de tus sueños</p>
                            </div>
                        </div>
                    </div>
                    <div className="carousel-item">
                        <img src='public/main2.jpg' alt='Primer img' className="bd-placeholder-img" width={"auto"} aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false" />
                        <div className="container">
                            <div className="carousel-caption bg-dark bg-opacity-50 text-white start-0 end-0 bottom-0">
                                <p className='fs-1 fw-medium mb-4 mt-3'>Propiedades y confianza</p>
                            </div>
                        </div>
                    </div>
                </div>
                <button className="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
                    <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span className="visually-hidden">Previous</span>
                </button>
                <button className="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
                    <span className="carousel-control-next-icon" aria-hidden="true"></span>
                    <span className="visually-hidden">Next</span>
                </button>
            </div>

            <section className="hero align-items-stretch">
                <div className="hero-inferior">
                    <div className="container mt-3 mb-5">
                        <h3 className="mb-4">Sobre Nosotros</h3>
                        <h5 className="mt-4 mb-5">Somos más que una inmobiliaria; somos parte de su comunidad. Con un conocimiento profundo de cada vecindario, ofrecemos un asesoramiento personalizado y un proceso simplificado. En Mr. House Inmobiliaria, estamos aquí para hacer realidad sus sueños de propiedad.</h5>
                    </div>
                    <div>
                        <img className="hero-inferior-imagen img-fluid pb-4" src="public/logo_header.jpeg" alt="imagen hero logo" />
                    </div>
                </div>
            </section>

            <div id='nosotros'>
                {<About />}
            </div>
            <div id='venta'>
                {<Projects />}
            </div>

        </div>
    )
}