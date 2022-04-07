import { render, screen } from "@testing-library/react";
import useState from "react";
import AllProducts from "./../NewUI/Product/AllProducts";
import axios from "axios";
import { getAllCategories, getAllProductFromServer } from "./../NewUI/Product/helper/updateHelper";

jest.mock("axios");

test("Products loading or not", async () => {
  const products = [
    {
      productId: "pid1",
      productName: "ProductName",
      image: "Schwartz",
      price: 20,
    },
    {
      productId: "pid2",
      productName: "ProductName",
      image: "Schwartz",
      price: 50,
    },
  ];

  const resp = { data: products };

  axios.get.mockImplementation(() => Promise.resolve(resp));

  console.log(await getAllProductFromServer((res) => expect(res.data).toEqual(products)));
});

test("Categories loading or not", async () => {
  const categories = [
    {
      categoryId: "1",
      categoryName: "Footwear",
    },
    {
      categoryId: "2",
      categoryName: "Electronics",
    },
    {
      categoryId: "3",
      categoryName: "Utensils",
    },

  ];

  const resp = { data: categories };

  axios.get.mockImplementation(() => Promise.resolve(resp));

  console.log(await getAllCategories((res) => expect(res.data).toEqual(categories)));
});

