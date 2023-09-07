import axios from "axios";

const URL = "http://localhost:8080/api/inmueble/";

class InmuebleService {
    ingresarInmueble(inmuebleForm, token) {
        const config = {
            headers: {
                Authorization: `Bearer ${token}` }
        };
        return axios.post(URL + "registroInmueble", inmuebleForm, config);
    }
    getInmuebleAll(pagina, cantidad) {
        const params = {
            cantidad: cantidad,
            pagina: pagina
        };
        return axios.get(`${URL}listar`, { params });
    }
}
export default new InmuebleService();
