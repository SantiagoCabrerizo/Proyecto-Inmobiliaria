import axios from "axios";

const URL = "http://localhost:8080/api/inmueble/";

class InmuebleService {
    ingresarInmueble(inmuebleForm, token) {
        const config = {
            headers: {
                Authorization: `Bearer ${token}`,
            },
        };
        return axios.post(URL + "registroInmueble", inmuebleForm, config);
    }
    /*  getInmuebleAll() {
      return axios.get(URL + "listar");
    } */
    getInmuebleAll(pagina, cantidad) {
        const params = {
            cantidad: cantidad,
            pagina: pagina,
        };
        return axios.get(URL + "listar", { params });
    }
    getInmuebleById(inmuebleId) {
        return axios.get(URL + inmuebleId);
    }
    /* getInmuebleByUser(userId) {
      return axios.get(URL + userId);
    } */
}
export default new InmuebleService();