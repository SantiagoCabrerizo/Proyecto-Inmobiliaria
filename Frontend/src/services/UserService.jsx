import axios from "axios";

const URL = "http://localhost:8080/api/user/"

class UserService {

    getUsers() {
        return axios.get(URL + "usuarios")
    }

    createUsers(user) {
        return axios.post(URL + "registro", user)
    }

    getByIdWithToken(userId, token) {
        return axios.get(`${URL}${userId}`, {
            headers: {
                Authorization: `Bearer ${token}`
            },
        })
    }

    deleteUser(userId) {
        return axios.delete(URL + userId)
    }

}

export default new UserService();