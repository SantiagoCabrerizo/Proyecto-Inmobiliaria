import axios from "axios";

const URL = "http://localhost:8080/api/usuarios"

class UserService {

    getUsers(){
        return axios.get(URL)
    }

    createUser(user){
        return axios.post(URL, user)
    }


}

export default new UserService();