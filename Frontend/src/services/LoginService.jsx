import axios from "axios";

const URL = "http://localhost:8080/api/auth/";

class LoginService {
  loginUsers(login) {
    return axios.post(URL + "login", login);
  }
}

export default new LoginService();
