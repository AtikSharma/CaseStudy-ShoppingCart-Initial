import axios from "axios";
import api from "./../../api/webapi";
export const addCategory = async (category) => {
  return await axios.post(`${api}/category/addCategory`, category);
};
