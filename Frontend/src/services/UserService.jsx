import axios from "axios";

const URL = "http://localhost:8080/api/"

class UserService {

    getUsers() {
        return axios.get(URL + "usuarios")
    }

    createUsers(user) {
        return axios.post(URL + "registro", user)
    }

    getById(userId){
        return axios.get(URL + "usuarios" + '/' + userId)
    }

    deleteUser(userId){
        return axios.delete(URL + "usuarios" + '/' + userId)
    }

}

export default new UserService();