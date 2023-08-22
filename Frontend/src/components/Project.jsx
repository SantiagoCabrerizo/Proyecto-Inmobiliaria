import React from 'react'
import { Link } from 'react-router-dom';

export const Project = () => {
    return (
        <div>

            <div className="proyecto">
                <img src="https://api-prod.corelogic.com/trestle/Media/SEFMIAMI.SEFMIAMI_MIAMI/Property/PHOTO-jpeg/1040219637/1/MzI0MC8yMDI5LzY2/NjYvNTQ1OC8xNjkxMTE4NDAz/zPAmPS5zlfKHc9ewjqenKHsgd8eilllx9fhnaUA_zi8" alt="Listing A11417393 Photo 0" />
                <div className="overlay">
                    <p>Contact Name</p>
                    <Link to={"/contact"}>
                        <i className="bi bi-person"></i>
                    </Link>
                </div>
            </div>

        </div>
    )
}