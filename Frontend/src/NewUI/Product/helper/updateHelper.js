import axios from "axios";
import api from "./../../api/webapi";

export const getProductFromLocalStorage = () => {
  if (typeof window == "undefined") {
    return false;
  }
  if (localStorage.getItem("product")) {
    return JSON.parse(localStorage.getItem("product"));
  } else {
    return false;
  }
};

export const getAllProductFromServer = async () => {
  const res = await axios.get(`${api}/product/getAllProducts`);
  return res;
};

export const getAllCategories = async () => {
  const res = await axios.get(`${api}/category/allCategories`);
  return res;
};

export const getProductByCategory = async (name) => {
 const res = axios.get(`${api}/product/getProduct/category/${name}`);
 return res;
};
