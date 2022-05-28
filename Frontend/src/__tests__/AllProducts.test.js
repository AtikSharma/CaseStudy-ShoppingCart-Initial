import axios from "axios";
import {
  getAllCategories,
  getAllProductFromServer,
} from "./../NewUI/Product/helper/updateHelper";

jest.mock("axios");

describe("Axios Get Api Mocking", () => {
  it("Products loading or not", async () => {
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

    await getAllProductFromServer((res) => expect(res.data).toEqual(products));
  });

  it("Categories loading or not", async () => {
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

    await getAllCategories((res) => expect(res.data).toEqual(categories));
  });
});
