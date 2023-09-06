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
    getInmuebleAll() {
        return axios.get(URL + "listar");
    }
}
export default new InmuebleService();
