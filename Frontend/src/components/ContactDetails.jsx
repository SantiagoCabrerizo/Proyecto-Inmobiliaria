import React, { useEffect } from 'react'
import { Link } from 'react-router-dom';

export const ContactDetails = () => {

    useEffect(()=>{
        window.scrollTo(0, 0)
    })

    return (
        <div>
            <div className="container shadow p-3 mb-5 bg-body-tertiary rounded mt-3">
                <div className="row featurette">
                    <div className="col-md-7 order-md-2">
                        <h2 className="featurette-heading fw-normal lh-1">Contact Name</h2>
                        <p className="lead">Lorem, ipsum dolor sit amet consectetur adipisicing elit. Architecto ut beatae placeat, ipsa laborum aspernatur est excepturi temporibus tenetur consectetur doloribus nihil doloremque quis eum modi ad reiciendis harum dolores?</p>
                    </div>
                    <div className="col-md-5 overflow-auto">
                        <img className="rounded" width={500} src="https://api-prod.corelogic.com/trestle/Media/SEFMIAMI.SEFMIAMI_MIAMI/Property/PHOTO-jpeg/1040219637/1/MzI0MC8yMDI5LzY2/NjYvNTQ1OC8xNjkxMTE4NDAz/zPAmPS5zlfKHc9ewjqenKHsgd8eilllx9fhnaUA_zi8" alt="Listing A11417393 Photo 0" />
                    </div>
                </div>
                <div className='mt-3'>
                    <Link to={"/"}>
                        <i className="bi bi-arrow-left"></i>
                    </Link>
                </div>
            </div>

        </div>
    )
}