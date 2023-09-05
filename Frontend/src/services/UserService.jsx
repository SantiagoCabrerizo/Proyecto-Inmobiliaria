import axios from "axios";

const URL = "http://localhost:8080/api/user/"

class UserService {

    getUsers(token) {
        const config = {
            headers: {
                Authorization: `Bearer ${token}`
            }
        };
        return axios.get(URL + "usuarios", config)
    }

    createUsers(user) {
        return axios.post(URL + "registro", user)
    }

    getById(userId, token) {
        const config = {
            headers: {
                Authorization: `Bearer ${token}`
            }
        };
        return axios.get(URL + userId, config)
    }

    deleteUser(userId) {
        return axios.delete(URL + userId)
    }

}

export default new UserService();