import axios from "axios";

const URL = "http://localhost:8080/api/user/"

class UserService {

    getUsers() {
        return axios.get(URL + "usuarios")
    }

    createUsers(user) {
        return axios.post(URL + "registro", user)
    }

    getById(userId) {
        return axios.get(URL + userId)
    }

    deleteUser(userId) {
        return axios.delete(URL + userId)
    }

}

export default new UserService();