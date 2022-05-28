import axios from "axios";
import api from './../../api/webapi';

export const loadUser = (id) => {
    axios.get(`${api}/profile/getProfile/${id}`).then(
        (response) => { 
           localStorage.setItem("user", JSON.stringify(response.data))
        //    localStorage.setItem("address", JSON.stringify(response.data.userAddresses))
        },
        (error) => {
            console.log("Erroer:->>>> " + error);
        }
    )
   };

export const loadAllUsers = async () => {
    const res = axios.get(`${api}/profile/getAllProfiles`);
    return res ? res : res.catch(error => error);
}